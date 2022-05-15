package com.supportportal.resource;

import com.supportportal.domain.Ticket;
import com.supportportal.domain.TicketMembreEquipe;
import com.supportportal.service.TicketMembreEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TicketMembreEquipe")
public class TicketMembreEquipeResource {
    @Autowired
    private TicketMembreEquipeService ticketMembreEquipeService;
    @GetMapping("/collaborateur/{codeCollaborateur}/ticket/{codeTicket}")
    public TicketMembreEquipe findByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(@PathVariable String codeCollaborateur,@PathVariable String codeTicket) {
        return ticketMembreEquipeService.findByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(codeCollaborateur, codeTicket);
    }
    @DeleteMapping("/collaborateur/{codeCollaborateur}/ticket/{codeTicket}")
    public int deleteByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(@PathVariable String codeCollaborateur,@PathVariable String codeTicket) {
        return ticketMembreEquipeService.deleteByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(codeCollaborateur, codeTicket);
    }
    @GetMapping("/code/{code}")
    public List<TicketMembreEquipe> findByTicketCode(@PathVariable String code) {
        return ticketMembreEquipeService.findByTicketCode(code);
    }
    @DeleteMapping("/code/{code}/refEquipe/{ref}/ticket/{codeTicket}")
    public int deleteByMembreEquipeCollaborateurCodeCollaborateurAndEquipeRefAndTicketCode(@PathVariable String code,@PathVariable String ref,@PathVariable String codeTicket) {
        return ticketMembreEquipeService.deleteByMembreEquipeCollaborateurCodeCollaborateurAndEquipeRefAndTicketCode(code, ref, codeTicket);
    }
    @GetMapping("/codeMembre/{code}")
    public TicketMembreEquipe findByMembreEquipeCollaborateurCodeCollaborateur(@PathVariable String code) {
        return ticketMembreEquipeService.findByMembreEquipeCollaborateurCodeCollaborateur(code);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByTicketCode(@PathVariable String code) {
        return ticketMembreEquipeService.deleteByTicketCode(code);
    }
    @PutMapping("/")
    public TicketMembreEquipe update(@RequestBody TicketMembreEquipe ticketMembreEquipe) {
        return ticketMembreEquipeService.update(ticketMembreEquipe);
    }
    @PostMapping("/")
    public int save(@RequestBody TicketMembreEquipe ticketMembreEquipe,@RequestBody Ticket ticket) {
        return ticketMembreEquipeService.save(ticketMembreEquipe, ticket);
    }
}
