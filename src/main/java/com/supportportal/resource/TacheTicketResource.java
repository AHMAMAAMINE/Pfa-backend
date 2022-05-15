package com.supportportal.resource;

import com.supportportal.domain.TacheTicket;
import com.supportportal.service.TacheTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tacheTicket")
public class TacheTicketResource {
    @Autowired
    private TacheTicketService tacheTicketService;
    @GetMapping("/")
    public List<TacheTicket> findAll() {
        return tacheTicketService.findAll();
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return tacheTicketService.deleteByCode(code);
    }
    @GetMapping("/code/{code}")
    public TacheTicket findByCode(@PathVariable String code) {
        return tacheTicketService.findByCode(code);
    }

    @GetMapping("/codeCollaborateur/{codeCollaborateur}")
    public List<TacheTicket> findByMembreEquipeCollaborateurCodeCollaborateur(@PathVariable String codeCollaborateur) {
        return tacheTicketService.findByMembreEquipeCollaborateurCodeCollaborateur(codeCollaborateur);
    }
    @GetMapping("/codeTicket/{code}")
    public List<TacheTicket> findByTicketCode(@PathVariable String code) {
        return tacheTicketService.findByTicketCode(code);
    }
    @GetMapping("/collaborateur/{codeCollaborateur}/ticket/{codeTicket}")
    public List<TacheTicket> findByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(@PathVariable String codeCollaborateur,@PathVariable String codeTicket) {
        return tacheTicketService.findByMembreEquipeCollaborateurCodeCollaborateurAndTicketCode(codeCollaborateur, codeTicket);
    }
    @PostMapping("/")
    public int save(@RequestBody TacheTicket tacheTicket) {
        return tacheTicketService.save(tacheTicket);
    }
    @PutMapping("/")
    public TacheTicket update(@RequestBody TacheTicket tacheTicket) {
        return tacheTicketService.update(tacheTicket);
    }
}
