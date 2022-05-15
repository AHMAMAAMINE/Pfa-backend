package com.supportportal.service.impl;

import com.supportportal.domain.Conseils;
import com.supportportal.domain.Ticket;
import com.supportportal.domain.TicketMembreEquipe;
import com.supportportal.repository.TicketRepository;
import com.supportportal.service.ConseillsService;
import com.supportportal.service.TicketMembreEquipeService;
import com.supportportal.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;
    private TicketMembreEquipeService ticketMembreEquipeService;
    private ConseillsService conseilsService;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, TicketMembreEquipeService ticketMembreEquipeService, ConseillsService conseilsService) {
        this.ticketRepository = ticketRepository;
        this.ticketMembreEquipeService = ticketMembreEquipeService;
        this.conseilsService = conseilsService;
    }

    @Override
    public Ticket findByCode(String code) {
        return ticketRepository.findByCode(code);
    }

    @Override
    public List<Ticket> findByDateDeProbleme(String dateDeProbleme) {
        return ticketRepository.findByDateDeProbleme(dateDeProbleme);
    }

    @Override
    public List<Ticket> findByDateDebutAndDateFin(String dateDebut, String DateFin) {
        return ticketRepository.findByDateDebutAndDateFin(dateDebut, DateFin);
    }

    @Override
    public List<Ticket> findByEtatTicket(String etatTicket) {
        return ticketRepository.findByEtatTicket(etatTicket);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> findByTicketMembreEquipeEquipeRef(String ref) {
        return ticketRepository.findByTicketMembreEquipeEquipeRef(ref);
    }

    @Override
    public List<Ticket> findByTicketMembreEquipeMembreEquipeCollaborateurCodeCollaborateur(String code) {
        return ticketRepository.findByTicketMembreEquipeMembreEquipeCollaborateurCodeCollaborateur(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return ticketRepository.deleteByCode(code);
    }

    @Transactional
    public int deleteByEtatTicket(String etatTicket) {
        return ticketRepository.deleteByEtatTicket(etatTicket);
    }


    @Override
    public int save(Ticket ticket) {
        if (findByCode(ticket.getCode()) == null) {
            ticketRepository.save(ticket);
            int  a = 2, c = 2;
            for (TicketMembreEquipe ticketMembreEquipe : ticket.getTicketMembreEquipe()) {
                a = ticketMembreEquipeService.save(ticketMembreEquipe, ticket);
            }
            for (Conseils conseils : ticket.getConseils()) {
                c = conseilsService.save(ticket, conseils);
            }

            return a + c;
        } else
            return -1;
    }

    @Override
    public int update(Ticket ticket) {
        Ticket tickets = findByCode(ticket.getCode());
        if (tickets != null) {
            tickets.setEtatTicket(ticket.getEtatTicket());
            if(ticket.getTicketMembreEquipe()!=null) {
                ticketMembreEquipeService.deleteByTicketCode(ticket.getCode());
                for (TicketMembreEquipe membreEquipe : ticket.getTicketMembreEquipe()) {
                    if(ticketMembreEquipeService.findByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(membreEquipe.getMembreEquipe().getCollaborateur().getCodeCollaborateur(),ticket.getCode())==null) {
                        ticketMembreEquipeService.save(membreEquipe,ticket);
                    }
                }
                tickets.setTicketMembreEquipe(ticket.getTicketMembreEquipe());
            }
            tickets.setCode(ticket.getCode());
            if(ticket.getConseils()!=null)
            {
                conseilsService.deleteByTicketCode(ticket.getCode());
                for (Conseils conseils : ticket.getConseils()) {
                    conseilsService.save(ticket, conseils);
                }}
            tickets.setConseils(ticket.getConseils());
            tickets.setDateDebut(ticket.getDateDebut());
            tickets.setDateDeProbleme(ticket.getDateDeProbleme());
            tickets.setDateFin(ticket.getDateFin());
            tickets.setDescription(ticket.getDescription());
            tickets.setLibelle(ticket.getLibelle());
            ticketRepository.save(tickets);
            return 1;
        } else
            return -2;
    }
}
