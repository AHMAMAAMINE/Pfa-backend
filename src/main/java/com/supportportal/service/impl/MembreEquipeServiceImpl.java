package com.supportportal.service.impl;

import com.supportportal.domain.Collaborateur;
import com.supportportal.domain.MembreEquipe;
import com.supportportal.domain.User;
import com.supportportal.exception.domain.EmailExistException;
import com.supportportal.exception.domain.NotAnImageFileException;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.exception.domain.UsernameExistException;
import com.supportportal.repository.MembreEquipeRepository;
import com.supportportal.service.CollaborateurService;
import com.supportportal.service.MembreEquipeService;
import com.supportportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
public class MembreEquipeServiceImpl implements MembreEquipeService {

    private MembreEquipeRepository membreEquipeRepository;
    private CollaborateurService collaborateurService;
    private UserService userService;


    @Autowired
    public MembreEquipeServiceImpl(MembreEquipeRepository membreEquipeRepository, CollaborateurService collaborateurService,UserService userService) {
        this.membreEquipeRepository = membreEquipeRepository;
        this.collaborateurService = collaborateurService;
        this.userService = userService;
    }


    @Override
    public List<MembreEquipe> findByEquipeRef(String ref) {
        return membreEquipeRepository.findByEquipeRef(ref);
    }

    @Override
    public MembreEquipe findByCollaborateurCodeCollaborateur(String code) {
        return membreEquipeRepository.findByCollaborateurCodeCollaborateur(code);
    }

    @Transactional
    public int deleteByCollaborateurCodeCollaborateur(String code) {
        return membreEquipeRepository.deleteByCollaborateurCodeCollaborateur(code);
    }

    @Override
    public List<MembreEquipe> findAll() {
        return membreEquipeRepository.findAll();
    }

    @Override
    public MembreEquipe save(MembreEquipe membreEquipe) throws UserNotFoundException, EmailExistException, IOException, UsernameExistException, NotAnImageFileException {
        Collaborateur collaborateur = collaborateurService.findByCodeCollaborateur(membreEquipe.getCollaborateur().getCodeCollaborateur());
            User user=userService.findUserByUsername(collaborateur.getUser().getUsername());
            userService.updateUser(user.getUsername(), user.getFirstName(),user.getLastName(),user.getUsername(),user.getEmail(),"ROLE_MEMBRE",user.isNotLocked(),user.isActive(),null);
            membreEquipe.setCollaborateur(collaborateurService.findByCodeCollaborateur(membreEquipe.getCollaborateur().getCodeCollaborateur()));
            membreEquipeRepository.save(membreEquipe);
            return membreEquipe;
    }

    @Override
    public MembreEquipe update(MembreEquipe membreEquipe) {
        return null;
    }
}
