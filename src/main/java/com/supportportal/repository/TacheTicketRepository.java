package com.supportportal.repository;

import com.supportportal.domain.TacheTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheTicketRepository extends JpaRepository<TacheTicket,Long> {
    List<TacheTicket> findAll();
     int deleteByCode(String code);
      TacheTicket findByCode(String code);
     List<TacheTicket>  findByMembreEquipeCollaborateurCodeCollaborateur(String codeCollaborateur);
     List<TacheTicket>  findByTicketCode(String code);
     List<TacheTicket>  findByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(String codeCollaborateur, String codeTicket);
}
