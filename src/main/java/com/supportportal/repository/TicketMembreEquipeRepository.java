package com.supportportal.repository;

import com.supportportal.domain.TicketMembreEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketMembreEquipeRepository extends JpaRepository<TicketMembreEquipe,Long> {
    TicketMembreEquipe findByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(String codeCollaborateur, String codeTicket);
    int deleteByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(String codeCollaborateur,String codeTicket);
    List<TicketMembreEquipe> findByTicketCode(String code);
    int deleteByMembreEquipeCollaborateurCodeCollaborateurAndEquipeRefAndTicketCode(String code,String ref,String interv);
    TicketMembreEquipe findByMembreEquipeCollaborateurCodeCollaborateur(String code);
    int deleteByTicketCode(String code);
}
