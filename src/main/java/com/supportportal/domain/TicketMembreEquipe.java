package com.supportportal.domain;

import javax.persistence.*;

@Entity
public class TicketMembreEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private MembreEquipe membreEquipe;
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Ticket ticket;
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Equipe equipe;

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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
