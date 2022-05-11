package com.supportportal.domain;

import javax.persistence.*;

@Entity
public class Collaborateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codeCollaborateur;
    @OneToOne
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
