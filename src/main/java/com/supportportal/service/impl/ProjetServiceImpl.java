package com.supportportal.service.impl;

import com.supportportal.domain.Projet;
import com.supportportal.domain.Ticket;
import com.supportportal.repository.ProjetRepository;
import com.supportportal.service.ProjetService;
import com.supportportal.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjetServiceImpl implements ProjetService {
    private ProjetRepository projetRepository;
    private TicketService ticketService;

    @Autowired
    public ProjetServiceImpl(ProjetRepository projetRepository, TicketService ticketService) {
        this.projetRepository = projetRepository;
        this.ticketService = ticketService;
    }

    @Override
    public Projet findByRef(String ref) {
        return projetRepository.findByRef(ref);
    }

    @Override
    public List<Projet> findAll() {
        return projetRepository.findAll();
    }

    @Transactional
    public int deleteByRef(String ref) {
        return projetRepository.deleteByRef(ref);
    }

    @Override
    public int save(Projet projet) {
        Projet projet1=projetRepository.findByRef(projet.getRef());
        if(projet1==null){
            for(Ticket ticket:projet.getTickets()){
                ticketService.save(ticket);
            }
            projetRepository.save(projet);
            return 1;
        }
        return 0;
    }

    @Override
    public Projet update(Projet projet) {
        int a;
        List<Ticket>tickets=new ArrayList<>();
        Projet projetUpdate=projetRepository.findByRef(projet.getRef());
        if(projetUpdate!=null){
            for(Ticket ticket:projet.getTickets()){
                a=ticketService.save(ticket);
                if(a==1)
                    tickets.add(ticket);
            }
            projetUpdate.setTickets(tickets);
            projetUpdate.setDescription(projet.getDescription());
            projetRepository.save(projet);
            return projetUpdate;
        }
        return null;
    }
}
