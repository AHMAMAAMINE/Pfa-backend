package com.supportportal.service.impl;

import com.supportportal.domain.Collaborateur;
import com.supportportal.domain.User;
import com.supportportal.exception.domain.EmailExistException;
import com.supportportal.exception.domain.NotAnImageFileException;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.exception.domain.UsernameExistException;
import com.supportportal.repository.CollaborateurRepository;
import com.supportportal.service.CollaborateurService;
import com.supportportal.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

import static com.supportportal.constant.CollaborateurImplConstant.*;

public class CollaborateurServiceImpl implements CollaborateurService {

    private UserService userService;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    CollaborateurRepository collaborateurRepository;
    @Autowired
    public CollaborateurServiceImpl(CollaborateurRepository collaborateurRepository, UserService userService){
        this.collaborateurRepository=collaborateurRepository;
        this.userService=userService;
    }

    @Override
    public Collaborateur findByCodeCollaborateur(String codeCollaborateur) {
        return collaborateurRepository.findByCodeCollaborateur(codeCollaborateur);
    }

    @Override
    public int deleteByCodeCollaborateur(String codeCollaborateur) {
        return collaborateurRepository.deleteByCodeCollaborateur(codeCollaborateur);
    }

    @Override
    public List<Collaborateur> findAll() {
        return collaborateurRepository.findAll();
    }

    @Override
    public Collaborateur save(Collaborateur collaborateur) throws UserNotFoundException, EmailExistException, IOException, UsernameExistException, NotAnImageFileException {
        if (findByCodeCollaborateur(collaborateur.getCodeCollaborateur()) != null) {
            LOGGER.error(COLLABORATEUR_ALREADY_EXISTS + collaborateur.getUser().getUsername());
            throw new UsernameNotFoundException(COLLABORATEUR_ALREADY_EXISTS + collaborateur.getUser().getUsername());
        }
        else {
            User user = userService.addNewUser(collaborateur.getUser().getFirstName()
                    , collaborateur.getUser().getLastName()
                    , collaborateur.getUser().getUsername()
                    , collaborateur.getUser().getEmail()
                    , collaborateur.getUser().getRole()
                    , collaborateur.getUser().isNotLocked()
                    , collaborateur.getUser().isActive()
                    , null);
            collaborateur.setUser(user);
            collaborateurRepository.save(collaborateur);
            return collaborateur;
        }
    }

    @Override
    public Collaborateur update(Collaborateur collaborateur, MultipartFile profileImage) throws UserNotFoundException, EmailExistException, IOException, UsernameExistException, NotAnImageFileException {
        Collaborateur collaborateurUpdate=collaborateurRepository.findByCodeCollaborateur(collaborateur.getCodeCollaborateur());
        if(collaborateurUpdate==null) {
            LOGGER.error(NO_COLLABORATEUR_FOUND_BY_CODE + collaborateur.getUser().getUsername());
            throw new UsernameNotFoundException( NO_COLLABORATEUR_FOUND_BY_CODE + collaborateur.getUser().getUsername());
        }
        else{
            User user=userService.updateUser(collaborateur.getUser().getUsername(),
                    collaborateur.getUser().getFirstName()
                    , collaborateur.getUser().getLastName()
                    , collaborateur.getUser().getUsername()
                    , collaborateur.getUser().getEmail()
                    , collaborateur.getUser().getRole()
                    , collaborateur.getUser().isNotLocked()
                    , collaborateur.getUser().isActive()
                    , profileImage);
            collaborateurUpdate.setUser(user);
        }
        return collaborateurUpdate;
    }
}
