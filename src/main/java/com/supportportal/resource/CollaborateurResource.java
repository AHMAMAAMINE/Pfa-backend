package com.supportportal.resource;

import com.supportportal.domain.Collaborateur;
import com.supportportal.exception.domain.EmailExistException;
import com.supportportal.exception.domain.NotAnImageFileException;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.exception.domain.UsernameExistException;
import com.supportportal.service.CollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Collaborateur")
public class CollaborateurResource {
    @Autowired
    private CollaborateurService collaborateurService;

    @GetMapping("/codeCollaborateur/{codeCollaborateur}")
    public Collaborateur findByCodeCollaborateur(@PathVariable String codeCollaborateur) {
        return collaborateurService.findByCodeCollaborateur(codeCollaborateur);
    }
    @GetMapping("/username/{username}")
    public Collaborateur findByUserUsername(@PathVariable String username) {
        return collaborateurService.findByUserUsername(username);
    }
    @DeleteMapping("/codeCollaborateur/{codeCollaborateur}")
    public int deleteByCodeCollaborateur(@PathVariable String codeCollaborateur) {
        return collaborateurService.deleteByCodeCollaborateur(codeCollaborateur);
    }
    @GetMapping("/")
    public List<Collaborateur> findAll() {
        return collaborateurService.findAll();
    }

    @PostMapping("/")
    public Collaborateur save(@RequestBody Collaborateur collaborateur) throws UserNotFoundException, EmailExistException, IOException, UsernameExistException, NotAnImageFileException {
        return collaborateurService.save(collaborateur);
    }
    @PutMapping("/")
    public Collaborateur update(@RequestBody Collaborateur collaborateur,
                                @RequestParam(value = "profileImage", required = false) MultipartFile profileImage) throws UserNotFoundException, EmailExistException, IOException, UsernameExistException, NotAnImageFileException {
        return collaborateurService.update(collaborateur, profileImage);
    }
}
