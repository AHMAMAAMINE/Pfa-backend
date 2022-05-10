package com.supportportal.domain;

import javax.persistence.*;

@Entity
public class Conseils {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private MembreEquipe membreEquipe;
    // @ManyToOne
    // private Equipe equipe;
    private String message;
    @ManyToOne
    private Ticket ticket;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MembreEquipe getMembreEquipe() {
        return membreEquipe;
    }

    public void setMembreEquipe(MembreEquipe membreEquipe) {
        this.membreEquipe = membreEquipe;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
