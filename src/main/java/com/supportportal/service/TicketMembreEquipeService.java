package com.supportportal.service;

import com.supportportal.domain.TicketMembreEquipe;

import java.util.List;

public interface TicketMembreEquipeService {
    TicketMembreEquipe findByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(String codeCollaborateur, String codeTicket);
    int deleteByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(String codeCollaborateur,String codeTicket);
    List<TicketMembreEquipe> findByTicketCode(String code);
    int deleteByMembreEquipeCollaborateurCodeCollaborateurAndEquipeRefAndTicketCode(String code,String ref,String interv);
    TicketMembreEquipe findByMembreEquipeCollaborateurCodeCollaborateur(String code);
    int deleteByTicketCode(String code);
    TicketMembreEquipe update(TicketMembreEquipe ticketMembreEquipe);
    int save(TicketMembreEquipe ticketMembreEquipe);
}
