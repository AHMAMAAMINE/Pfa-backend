package com.supportportal.service;

import com.supportportal.domain.Equipe;
import com.supportportal.exception.domain.EmailExistException;
import com.supportportal.exception.domain.NotAnImageFileException;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.exception.domain.UsernameExistException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EquipeService {
     Equipe findByLibelle(String libelle);

     Equipe findByChefEquipeCollaborateurCodeCollaborateur(String Code);

     Equipe findByCode(String code);

     Equipe findByRef(String ref);

     int deleteByRef(String ref);

     List<Equipe> findAll();

     Equipe save(Equipe equipe,MultipartFile profileImage) throws UserNotFoundException, EmailExistException, IOException, UsernameExistException, NotAnImageFileException, UserNotFoundException ;

     Equipe update(Equipe equipe, MultipartFile profileImage) throws UserNotFoundException, EmailExistException, IOException, UsernameExistException, NotAnImageFileException;
}
