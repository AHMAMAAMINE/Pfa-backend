package com.supportportal.service;

import com.supportportal.domain.Equipe;

import java.util.List;

public interface EquipeServic {
     Equipe findByLibelle(String libelle);

     Equipe findByChefEquipeCollaborateurCodeCollaborateur(String Code);

     Equipe findByCode(String code);

     Equipe findByRef(String ref);

     int deleteByRef(String ref);

     List<Equipe> findAll();

     int save(Equipe equipe);

     Equipe update(Equipe equipe);
}
