package com.supportportal.service;

import com.supportportal.domain.Ticket;

import java.util.List;

public interface TicketService {
    Ticket findByCode(String code);
    List<Ticket> findByDateDeProbleme(String dateDeProbleme);
    List<Ticket> findByDateDebutAndDateFin(String dateDebut,String DateFin);
    List<Ticket> findByEtatTicket(String etatTicket);
    List<Ticket> findAll();
    List<Ticket> findByTicketMembreEquipeEquipeRef(String ref);
    List<Ticket> findByTicketMembreEquipeMembreEquipeCollaborateurCodeCollaborateur(String code);
    int deleteByCode(String code);
    int deleteByEtatTicket(String etatTicket);
    int save(Ticket ticket);
    int update(Ticket ticket);
}
