package com.supportportal.resource;

import com.supportportal.domain.Equipe;
import com.supportportal.exception.domain.EmailExistException;
import com.supportportal.exception.domain.NotAnImageFileException;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.exception.domain.UsernameExistException;
import com.supportportal.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Equipe")
public class EquipeResource {
    @Autowired
    private EquipeService equipeService;
    @GetMapping("/libelle/{libelle}")
    public Equipe findByLibelle(@PathVariable String libelle) {
        return equipeService.findByLibelle(libelle);
    }
    @GetMapping("/code/{Code}")
    public Equipe findByChefEquipeCollaborateurCodeCollaborateur(@PathVariable String Code) {
        return equipeService.findByChefEquipeCollaborateurCodeCollaborateur(Code);
    }
    @GetMapping("/code/{code}")
    public Equipe findByCode(@PathVariable String code) {
        return equipeService.findByCode(code);
    }
    @GetMapping("/ref/{ref}")
    public Equipe findByRef(@PathVariable String ref) {
        return equipeService.findByRef(ref);
    }
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return equipeService.deleteByRef(ref);
    }
    @GetMapping("/")
    public List<Equipe> findAll() {
        return equipeService.findAll();
    }
    @PostMapping("/")
    public Equipe save(@RequestBody Equipe equipe, @RequestParam(value = "profileImage", required = false) MultipartFile profileImage) throws UserNotFoundException, EmailExistException, IOException, UsernameExistException, NotAnImageFileException, UserNotFoundException {
        return equipeService.save(equipe, profileImage);
    }
    @PutMapping("/")
    public Equipe update(@RequestBody Equipe equipe, @RequestParam(value = "profileImage", required = false) MultipartFile profileImage) throws UserNotFoundException, EmailExistException, IOException, UsernameExistException, NotAnImageFileException {
        return equipeService.update(equipe, profileImage);
    }
}
