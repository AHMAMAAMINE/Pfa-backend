package com.supportportal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Collaborateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codeCollaborateur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeCollaborateur() {
        return codeCollaborateur;
    }

    public void setCodeCollaborateur(String codeCollaborateur) {
        this.codeCollaborateur = codeCollaborateur;
    }
}
