package com.supportportal.service.impl;

import com.supportportal.domain.*;
import com.supportportal.repository.TicketMembreEquipeRepository;
import com.supportportal.service.EquipeService;
import com.supportportal.service.MembreEquipeService;
import com.supportportal.service.TicketMembreEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TicketMembreEquipeServiceImpl implements TicketMembreEquipeService {

    private TicketMembreEquipeRepository ticketMembreEquipeRepository;
    private MembreEquipeService membreEquipeService;
    private EquipeService equipeService;

    @Autowired
    public TicketMembreEquipeServiceImpl(TicketMembreEquipeRepository ticketMembreEquipeRepository, MembreEquipeService membreEquipeService, EquipeService equipeService) {
        this.ticketMembreEquipeRepository = ticketMembreEquipeRepository;
        this.membreEquipeService = membreEquipeService;
        this.equipeService = equipeService;
    }

    @Override
    public TicketMembreEquipe findByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(String codeCollaborateur, String codeTicket) {
        return ticketMembreEquipeRepository.findByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(codeCollaborateur,codeTicket);
    }

    @Transactional
    public int deleteByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(String codeCollaborateur, String codeTicket) {
        return ticketMembreEquipeRepository.deleteByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(codeCollaborateur, codeTicket);
    }

    @Override
    public List<TicketMembreEquipe> findByTicketCode(String code) {
        return ticketMembreEquipeRepository.findByTicketCode(code);
    }

    @Transactional
    public int deleteByMembreEquipeCollaborateurCodeCollaborateurAndEquipeRefAndTicketCode(String code, String ref, String interv) {
        return ticketMembreEquipeRepository.deleteByMembreEquipeCollaborateurCodeCollaborateurAndEquipeRefAndTicketCode(code, ref, interv);
    }

    @Override
    public TicketMembreEquipe findByMembreEquipeCollaborateurCodeCollaborateur(String code) {
        return ticketMembreEquipeRepository.findByMembreEquipeCollaborateurCodeCollaborateur(code);
    }

    @Transactional
    public int deleteByTicketCode(String code) {
        return ticketMembreEquipeRepository.deleteByTicketCode(code);
    }

    @Override
    public TicketMembreEquipe update(TicketMembreEquipe ticketMembreEquipe) {

        return null;
    }

    @Override
    public int save(TicketMembreEquipe ticketMembreEquipe, Ticket ticket) {
        Equipe equipe=equipeService.findByRef(ticketMembreEquipe.getEquipe().getRef());
        MembreEquipe membreEquipe=membreEquipeService.findByCollaborateurCodeCollaborateur(ticketMembreEquipe.getMembreEquipe().getCollaborateur().getCodeCollaborateur());
        if (membreEquipe==null || equipe ==null)
            return -2;
        TicketMembreEquipe ticketMembreEquip =new TicketMembreEquipe();
        ticketMembreEquip.setEquipe(equipe);
        ticketMembreEquip.setTicket(ticket);
        ticketMembreEquip.setMembreEquipe(membreEquipe);
        ticketMembreEquipeRepository.save(ticketMembreEquip);
        return 1;
    }

}
