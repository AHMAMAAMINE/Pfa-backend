package com.supportportal.repository;

import com.supportportal.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    Ticket findByCode(String code);
    List<Ticket> findByDateDeProbleme(String dateDeProbleme);
    List<Ticket> findByDateDebutAndDateFin(String dateDebut,String DateFin);
    List<Ticket> findByEtatTicket(String etatTicket);
    List<Ticket> findAll();
    List<Ticket> findByTicketMembreEquipeEquipeRef(String ref);
    List<Ticket> findByTicketMembreEquipeMembreEquipeCollaborateurCodeCollaborateur(String code);
    int deleteByCode(String code);
    int deleteByEtatTicket(String etatTicket);
}
