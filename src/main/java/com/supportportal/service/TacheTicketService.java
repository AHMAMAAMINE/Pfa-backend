package com.supportportal.service;

import com.supportportal.domain.TacheTicket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheTicketService{
    List<TacheTicket> findAll();
    int deleteByCode(String code);
    TacheTicket findByCode(String code);
    List<TacheTicket>  findByMembreEquipeCollaborateurCodeCollaborateur(String codeCollaborateur);
    List<TacheTicket>  findByTicketCode(String code);
    List<TacheTicket>  findByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(String codeCollaborateur, String codeTicket);
    int save(TacheTicket tacheTicket);
    TacheTicket update(TacheTicket tacheTicket);
}
