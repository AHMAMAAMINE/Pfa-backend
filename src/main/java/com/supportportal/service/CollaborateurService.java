package com.supportportal.service;

import com.supportportal.domain.Collaborateur;
import com.supportportal.exception.domain.EmailExistException;
import com.supportportal.exception.domain.NotAnImageFileException;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.exception.domain.UsernameExistException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CollaborateurService {
     Collaborateur findByCodeCollaborateur(String codeCollaborateur);

     int deleteByCodeCollaborateur(String codeCollaborateur);

    List<Collaborateur> findAll();

    Collaborateur save(Collaborateur collaborateur) throws UserNotFoundException, EmailExistException, IOException, UsernameExistException, NotAnImageFileException;

    Collaborateur update(Collaborateur collaborateur, MultipartFile profileImage) throws UserNotFoundException, EmailExistException, IOException, UsernameExistException, NotAnImageFileException;
}
