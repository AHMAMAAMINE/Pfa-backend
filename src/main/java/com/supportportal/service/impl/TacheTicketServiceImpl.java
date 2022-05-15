package com.supportportal.service.impl;

import com.supportportal.domain.MembreEquipe;
import com.supportportal.domain.TacheTicket;
import com.supportportal.domain.Ticket;
import com.supportportal.repository.TacheTicketRepository;
import com.supportportal.service.MembreEquipeService;
import com.supportportal.service.TacheTicketService;
import com.supportportal.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TacheTicketServiceImpl implements TacheTicketService {

    private TacheTicketRepository tacheTicketRepository;
    private MembreEquipeService membreEquipeService;
    private TicketService ticketService;

    @Autowired
    public TacheTicketServiceImpl(TacheTicketRepository tacheTicketRepository, MembreEquipeService membreEquipeService, TicketService ticketService) {
        this.tacheTicketRepository = tacheTicketRepository;
        this.membreEquipeService = membreEquipeService;
        this.ticketService = ticketService;
    }

    @Override
    public List<TacheTicket> findAll() {
        return tacheTicketRepository.findAll();
    }

    @Transactional
    public int deleteByCode(String code) {
        return tacheTicketRepository.deleteByCode(code);
    }

    @Override
    public TacheTicket findByCode(String code) {
        return tacheTicketRepository.findByCode(code);
    }

    @Override
    public List<TacheTicket> findByMembreEquipeCollaborateurCodeCollaborateur(String codeCollaborateur) {
        return tacheTicketRepository.findByMembreEquipeCollaborateurCodeCollaborateur(codeCollaborateur);
    }

    @Override
    public List<TacheTicket> findByTicketCode(String code) {
        return tacheTicketRepository.findByTicketCode(code);
    }

    @Override
    public List<TacheTicket> findByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(String codeCollaborateur, String codeTicket) {
        return tacheTicketRepository.findByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(codeCollaborateur, codeTicket);
    }

    @Override
    public int save(TacheTicket tacheTicket) {
        MembreEquipe membreEquipe = membreEquipeService.findByCollaborateurCodeCollaborateur(
                tacheTicket.getMembreEquipe().getCollaborateur().getCodeCollaborateur());
        Ticket ticket = ticketService.findByCode(tacheTicket.getTicket().getCode());
        if (ticket == null || membreEquipe == null) {
            return -1;
        }

        else {
            try {
                tacheTicket.setTicket(ticket);
                tacheTicket.setEtatTache(false);
                tacheTicket.setMembreEquipe(membreEquipe);
                tacheTicketRepository.save(tacheTicket);
                return 1;
            } catch (Exception e) {
                return -3;
            }
        }
    }

    @Override
    public TacheTicket update(TacheTicket tacheTicket) {
        TacheTicket tacheTicketUpdate = tacheTicketRepository.findByCode(tacheTicket.getCode());
        try {
            tacheTicketUpdate.setEtatTache(!tacheTicketUpdate.getEtatTache());
            tacheTicketRepository.save(tacheTicketUpdate);
            return tacheTicketUpdate;
        } catch (Exception e) {
            return null;
        }
    }

    public int completerTache(String codeTache) {
        TacheTicket tacheTicket  = tacheTicketRepository.findByCode(codeTache);
        try {
            tacheTicket.setEtatTache(!tacheTicket.getEtatTache());
            tacheTicketRepository.save(tacheTicket);
            return 1;
        } catch (Exception e) {
            return -3;
        }

    }
}
