package com.supportportal.repository;

import com.supportportal.domain.TacheTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheTicketRepository extends JpaRepository<TacheTicket,Long> {
    List<TacheTicket> findAll();
    public int deleteByCode(String code);
    public  TacheTicket findByCode(String code);
    public List<TacheTicket>  findByMembreEquipeCollaborateurCodeCollaborateur(String codeCollaborateur);
    public List<TacheTicket>  findByTicketCode(String code);
    public List<TacheTicket>  findByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(String codeCollaborateur, String codeTicket);
}
