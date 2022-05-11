package com.supportportal.service;

import com.supportportal.domain.Conseils;

import java.util.List;


public interface ConseillsService {
     List<Conseils> findByMembreEquipeCollaborateurCodeCollaborateur(String code);

     List<Conseils> findAll();

     void deleteById(Long id);

    int deleteByTicketCode(String code);

    int deleteByMembreEquipeCollaborateurCodeCollaborateurAndMessageAndTicketCode(String code, String message, String codeticket);

    List<Conseils> findByTicketCode(String code);

    Conseils save(Conseils conseils);

    Conseils update(Conseils conseils);
}
