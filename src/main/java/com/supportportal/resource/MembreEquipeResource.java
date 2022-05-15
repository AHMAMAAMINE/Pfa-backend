package com.supportportal.resource;

import com.supportportal.domain.MembreEquipe;
import com.supportportal.exception.domain.EmailExistException;
import com.supportportal.exception.domain.NotAnImageFileException;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.exception.domain.UsernameExistException;
import com.supportportal.service.MembreEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/MembreEquipe")
public class MembreEquipeResource {
    @Autowired
    private MembreEquipeService membreEquipeService;
    @GetMapping("/ref/{ref}")
    public List<MembreEquipe> findByEquipeRef(@PathVariable String ref) {
        return membreEquipeService.findByEquipeRef(ref);
    }
    @GetMapping("/code/{code}")
    public MembreEquipe findByCollaborateurCodeCollaborateur(@PathVariable String code) {
        return membreEquipeService.findByCollaborateurCodeCollaborateur(code);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCollaborateurCodeCollaborateur(@PathVariable String code) {
        return membreEquipeService.deleteByCollaborateurCodeCollaborateur(code);
    }
    @GetMapping("/")
    public List<MembreEquipe> findAll() {
        return membreEquipeService.findAll();
    }
    @PostMapping("/")
    public MembreEquipe save(@RequestBody MembreEquipe membreEquipe) throws UserNotFoundException, EmailExistException, IOException, UsernameExistException, NotAnImageFileException {
        return membreEquipeService.save(membreEquipe);
    }
    @PutMapping("/")
    public MembreEquipe update(@RequestBody MembreEquipe membreEquipe) {
        return membreEquipeService.update(membreEquipe);
    }
}
