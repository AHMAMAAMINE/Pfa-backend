package com.supportportal.service.impl;

import com.supportportal.constant.CollaborateurImplConstant;
import com.supportportal.domain.Collaborateur;
import com.supportportal.domain.Conseils;
import com.supportportal.repository.ConseillsRepository;
import com.supportportal.service.CollaborateurService;
import com.supportportal.service.ConseillsService;
import com.supportportal.service.MembreEquipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class Conseills  implements ConseillsService {

    private ConseillsRepository conseillsRepository;
    private CollaborateurService collaborateurService;
    private MembreEquipeService membreEquipeService ;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public Conseills(ConseillsRepository conseillsRepository, CollaborateurService collaborateurService,MembreEquipeService membreEquipeService) {
        this.conseillsRepository = conseillsRepository;
        this.collaborateurService = collaborateurService;
        this.membreEquipeService = membreEquipeService ;
    }


    @Override
    public List<Conseils> findByMembreEquipeCollaborateurCodeCollaborateur(String code) {
        return conseillsRepository.findByMembreEquipeCollaborateurCodeCollaborateur(code);
    }

    @Override
    public List<Conseils> findAll() {
        return conseillsRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        conseillsRepository.deleteById(id);
    }

    @Transactional
    public int deleteByTicketCode(String code) {
        return conseillsRepository.deleteByTicketCode(code);
    }

    @Transactional
    public int deleteByMembreEquipeCollaborateurCodeCollaborateurAndMessageAndTicketCode(String code, String message, String codeticket) {
        return conseillsRepository.deleteByMembreEquipeCollaborateurCodeCollaborateurAndMessageAndTicketCode(code, message, codeticket);
    }

    @Override
    public List<Conseils> findByTicketCode(String code) {
        return conseillsRepository.findByTicketCode(code);
    }

    @Override
    public Conseils save(Conseils conseils) {
        Collaborateur collaborateur=collaborateurService.findByUserUsername(conseils.getMembreEquipe().getCollaborateur().getUser().getUsername());
        if(collaborateur==null){
            LOGGER.error(CollaborateurImplConstant.NO_COLLABORATEUR_FOUND_BY_USERNAME+ collaborateur.getUser().getUsername());
            throw new UsernameNotFoundException(CollaborateurImplConstant.NO_COLLABORATEUR_FOUND_BY_USERNAME + collaborateur.getUser().getUsername());
        }
        else {
            conseils.setMembreEquipe(membreEquipeService.findByCollaborateurCodeCollaborateur(collaborateur.getCodeCollaborateur()));
            conseillsRepository.save(conseils);
            return conseils;
        }
    }

    @Override
    public Conseils update(Conseils conseils) {
        return null;
    }
}
