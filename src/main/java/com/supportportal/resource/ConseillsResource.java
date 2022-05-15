package com.supportportal.resource;

import com.supportportal.domain.Conseils;
import com.supportportal.domain.Ticket;
import com.supportportal.service.ConseillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Conseils")
public class ConseillsResource {
    @Autowired
    private ConseillsService conseillsService;
    @GetMapping("/CodeCollaborateur/{code}")
    public List<Conseils> findByMembreEquipeCollaborateurCodeCollaborateur(@PathVariable String code) {
        return conseillsService.findByMembreEquipeCollaborateurCodeCollaborateur(code);
    }
    @GetMapping("/")
    public List<Conseils> findAll() {
        return conseillsService.findAll();
    }
    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        conseillsService.deleteById(id);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByTicketCode(@PathVariable String code) {
        return conseillsService.deleteByTicketCode(code);
    }
    @DeleteMapping("code/{code}/message/{message}/ticket/{ticket}")
    public int deleteByMembreEquipeCollaborateurCodeCollaborateurAndMessageAndTicketCode(@PathVariable String code,@PathVariable String message,@PathVariable String ticket) {
        return conseillsService.deleteByMembreEquipeCollaborateurCodeCollaborateurAndMessageAndTicketCode(code, message, ticket);
    }
    @GetMapping("/code/{code}")
    public List<Conseils> findByTicketCode(@PathVariable String code) {
        return conseillsService.findByTicketCode(code);
    }
    @PostMapping("/")
    public int save(@RequestBody  Ticket ticket,@RequestBody Conseils conseils) {
        return conseillsService.save(ticket, conseils);
    }
    @PutMapping("/")
    public Conseils update(@RequestBody Conseils conseils) {
        return conseillsService.update(conseils);
    }
}
