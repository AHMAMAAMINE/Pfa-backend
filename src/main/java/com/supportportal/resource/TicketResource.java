package com.supportportal.resource;

import com.supportportal.domain.Ticket;
import com.supportportal.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ticket")
public class TicketResource {

    @Autowired
    private TicketService ticketService;
    @GetMapping("/code/{code}")
    public Ticket findByCode(@PathVariable String code) {
        return ticketService.findByCode(code);
    }
    @GetMapping("/dateDeProbleme/{dateDeProbleme}")
    public List<Ticket> findByDateDeProbleme(@PathVariable String dateDeProbleme) {
        return ticketService.findByDateDeProbleme(dateDeProbleme);
    }
    @GetMapping("/date/{dateDebut}/datefin/{DateFin}")
    public List<Ticket> findByDateDebutAndDateFin(@PathVariable String dateDebut,@PathVariable String DateFin) {
        return ticketService.findByDateDebutAndDateFin(dateDebut, DateFin);
    }
    @GetMapping("/etat/{etatTicket}")
    public List<Ticket> findByEtatTicket(@PathVariable String etatTicket) {
        return ticketService.findByEtatTicket(etatTicket);
    }
    @GetMapping("/")
    public List<Ticket> findAll() {
        return ticketService.findAll();
    }
    @GetMapping("/ref/{ref}")
    public List<Ticket> findByTicketMembreEquipeEquipeRef(@PathVariable String ref) {
        return ticketService.findByTicketMembreEquipeEquipeRef(ref);
    }
    @GetMapping("/codeTicket/{code}")
    public List<Ticket> findByTicketMembreEquipeMembreEquipeCollaborateurCodeCollaborateur(@PathVariable String code) {
        return ticketService.findByTicketMembreEquipeMembreEquipeCollaborateurCodeCollaborateur(code);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(String code) {
        return ticketService.deleteByCode(code);
    }
    @DeleteMapping("/etat/{etatTicket}")
    public int deleteByEtatTicket(String etatTicket) {
        return ticketService.deleteByEtatTicket(etatTicket);
    }
    @PostMapping("/")
    public int save(@RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }
    @PutMapping("/")
    public int update(@RequestBody Ticket ticket) {
        return ticketService.update(ticket);
    }
}
