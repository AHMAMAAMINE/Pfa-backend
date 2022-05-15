package com.supportportal.resource;

import com.supportportal.domain.Projet;
import com.supportportal.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Projet")
public class ProjetResource {

    @Autowired
    private ProjetService projetService;

    @GetMapping("/ref/{ref}")
    public Projet findByRef(@PathVariable String ref) {
        return projetService.findByRef(ref);
    }
    @GetMapping("/")
    public List<Projet> findAll() {
        return projetService.findAll();
    }
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return projetService.deleteByRef(ref);
    }
    @PostMapping("/")
    public int save(@RequestBody Projet projet) {
        return projetService.save(projet);
    }
    @PutMapping("/")
    public Projet update(@RequestBody Projet projet) {
        return projetService.update(projet);
    }
}
