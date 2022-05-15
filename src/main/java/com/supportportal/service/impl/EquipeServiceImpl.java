package com.supportportal.service.impl;

import com.supportportal.constant.CollaborateurImplConstant;
import com.supportportal.domain.Collaborateur;
import com.supportportal.domain.Equipe;
import com.supportportal.domain.MembreEquipe;
import com.supportportal.domain.User;
import com.supportportal.exception.domain.EmailExistException;
import com.supportportal.exception.domain.NotAnImageFileException;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.exception.domain.UsernameExistException;
import com.supportportal.repository.EquipeRepository;
import com.supportportal.service.CollaborateurService;
import com.supportportal.service.EquipeService;
import com.supportportal.service.MembreEquipeService;
import com.supportportal.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.supportportal.constant.EquipeImplConstant.EQUIPE_ALREADY_EXISTS;
import static com.supportportal.constant.EquipeImplConstant.NO_EQUIPE_FOUND_BY_REF;

@Service
public class EquipeServiceImpl implements EquipeService {


    private EquipeRepository equipeRepository;
    private MembreEquipeService membreEquipeService;
    private UserService userService;
    private CollaborateurService collaborateurService;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public EquipeServiceImpl(EquipeRepository equipeRepository, MembreEquipeService membreEquipeService, UserService userService,CollaborateurService collaborateurService) {
        this.equipeRepository = equipeRepository;
        this.membreEquipeService = membreEquipeService;
        this.collaborateurService = collaborateurService;
        this.userService = userService;
    }


    @Override
    public Equipe findByLibelle(String libelle) {
        return equipeRepository.findByLibelle(libelle);
    }

    @Override
    public Equipe findByChefEquipeCollaborateurCodeCollaborateur(String Code) {
        return equipeRepository.findByChefEquipeCollaborateurCodeCollaborateur(Code);
    }

    @Override
    public Equipe findByCode(String code) {
        return equipeRepository.findByCode(code);
    }

    @Override
    public Equipe findByRef(String ref) {
        return equipeRepository.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return equipeRepository.deleteByRef(ref);
    }

    @Override
    public List<Equipe> findAll() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe save(Equipe equipe, MultipartFile profileImage) throws UserNotFoundException, EmailExistException, IOException, UsernameExistException, NotAnImageFileException, UserNotFoundException {
        Collaborateur chefEquipe = collaborateurService.findByCodeCollaborateur(equipe.getChefEquipe().getCollaborateur().getCodeCollaborateur());
        if(equipeRepository.findByRef(equipe.getRef())!=null){
            LOGGER.error(EQUIPE_ALREADY_EXISTS + equipe.getCode());
            throw new UsernameNotFoundException(EQUIPE_ALREADY_EXISTS + equipe.getCode());
        }
        else{
            membreEquipeService.save(equipe.getChefEquipe());
            User user=userService.findUserByUsername(chefEquipe.getUser().getUsername());
            userService.updateUser(user.getUsername(), user.getFirstName(),user.getLastName(),user.getUsername(),user.getEmail(),"ROLE_MANAGER",user.isNotLocked(),user.isActive(),profileImage);
            equipe.getChefEquipe().setEquipe(equipe);
            equipeRepository.save(equipe);
            for (MembreEquipe membreEquipe : equipe.getMembres()) {
                membreEquipe.setEquipe(equipe);
                if (equipe.getChefEquipe().getCollaborateur().getCodeCollaborateur()
                        .equals(membreEquipe.getCollaborateur().getCodeCollaborateur()))
                    continue;
                membreEquipeService.save(membreEquipe);
            }
            return equipe;
        }
    }

    @Override
    public Equipe update(Equipe equipe,MultipartFile profileImage) throws UserNotFoundException, EmailExistException, IOException, UsernameExistException, NotAnImageFileException {
        Equipe equipeUpdate = findByRef(equipe.getRef());
        if (equipeUpdate != null) {
            equipeUpdate.setRef(equipe.getRef());
            equipeUpdate.setLibelle(equipe.getLibelle());
            equipeUpdate.setCode(equipe.getCode());
            MembreEquipe chefEquipe = membreEquipeService.findByCollaborateurCodeCollaborateur(
                    equipe.getChefEquipe().getCollaborateur().getCodeCollaborateur());
            Collaborateur chefEquipeCollaborateur = collaborateurService.findByCodeCollaborateur(equipe.getChefEquipe().getCollaborateur().getCodeCollaborateur());
            User NewuserChefDEquipe=userService.findUserByUsername(chefEquipeCollaborateur.getUser().getUsername());
            userService.updateUser(NewuserChefDEquipe.getUsername(), NewuserChefDEquipe.getFirstName(),NewuserChefDEquipe.getLastName(),NewuserChefDEquipe.getUsername(),NewuserChefDEquipe.getEmail(),"ROLE_MANAGER",NewuserChefDEquipe.isNotLocked(),NewuserChefDEquipe.isActive(),profileImage);
            if (chefEquipe == null) {
                membreEquipeService.save(equipe.getChefEquipe());
            }
            equipe.getChefEquipe().setEquipe(equipeUpdate);
            equipeUpdate.setChefEquipe(equipe.getChefEquipe());
            List<MembreEquipe> membreEquipeList = new ArrayList<>();
            equipeRepository.save(equipeUpdate);
            for (MembreEquipe membres : equipe.getMembres()) {
                MembreEquipe membreEquipe = membreEquipeService
                        .findByCollaborateurCodeCollaborateur(membres.getCollaborateur().getCodeCollaborateur());
                membres.setEquipe(equipeUpdate);
                if (equipe.getChefEquipe().getCollaborateur().getCodeCollaborateur()
                        .equals(membreEquipe.getCollaborateur().getCodeCollaborateur()))
                    continue;
                membreEquipeService.save(membres);
                membreEquipeList.add(membreEquipe);
            }
            equipeUpdate.setMembres(membreEquipeList);
            return equipeUpdate;
        } else {
            LOGGER.error(NO_EQUIPE_FOUND_BY_REF + equipe.getCode());
            throw new UsernameNotFoundException(NO_EQUIPE_FOUND_BY_REF + equipe.getCode());
        }
    }
}
