package com.supportportal.service;


import com.supportportal.domain.MembreEquipe;

import java.util.List;

public interface MembreEquipeService {

     List<MembreEquipe> findByEquipeRef(String ref);

     MembreEquipe findByCollaborateurCodeCollaborateur(String code);

     int deleteByCollaborateurCodeCollaborateur(String code);

    List<MembreEquipe> findAll();

    int save(MembreEquipe membreEquipe);

    MembreEquipe update(MembreEquipe membreEquipe);

}
