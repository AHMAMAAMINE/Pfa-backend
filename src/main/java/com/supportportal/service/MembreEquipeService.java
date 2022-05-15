package com.supportportal.service;


import com.supportportal.domain.MembreEquipe;
import com.supportportal.exception.domain.EmailExistException;
import com.supportportal.exception.domain.NotAnImageFileException;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.exception.domain.UsernameExistException;

import java.io.IOException;
import java.util.List;

public interface MembreEquipeService {

     List<MembreEquipe> findByEquipeRef(String ref);

     MembreEquipe findByCollaborateurCodeCollaborateur(String code);

     int deleteByCollaborateurCodeCollaborateur(String code);

    List<MembreEquipe> findAll();

    MembreEquipe save(MembreEquipe membreEquipe) throws UserNotFoundException, EmailExistException, IOException, UsernameExistException, NotAnImageFileException;

    MembreEquipe update(MembreEquipe membreEquipe);

}
