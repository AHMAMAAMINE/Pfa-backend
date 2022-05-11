package com.supportportal.service;

import com.supportportal.domain.Collaborateur;

import java.util.List;

public interface CollaborateurService {
     Collaborateur findByCodeCollaborateur(String codeCollaborateur);

     int deleteByCodeCollaborateur(String codeCollaborateur);

    List<Collaborateur> findAll();

    int save(Collaborateur collaborateur);

    Collaborateur update(Collaborateur collaborateur);
}
