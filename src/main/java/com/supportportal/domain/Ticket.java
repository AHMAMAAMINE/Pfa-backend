package com.supportportal.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateDeProbleme;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;
    private String description;
    private String libelle;
    private String code;
    //    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String etatTicket;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "ticket")
    private List<TicketMembreEquipe> ticketMembreEquipe;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy="ticket")
    private List<Conseils> conseils;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDeProbleme() {
        return dateDeProbleme;
    }

    public void setDateDeProbleme(Date dateDeProbleme) {
        this.dateDeProbleme = dateDeProbleme;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEtatTicket() {
        return etatTicket;
    }

    public void setEtatTicket(String etatTicket) {
        this.etatTicket = etatTicket;
    }

    public List<TicketMembreEquipe> getTicketMembreEquipe() {
        return ticketMembreEquipe;
    }

    public void setTicketMembreEquipe(List<TicketMembreEquipe> ticketMembreEquipe) {
        this.ticketMembreEquipe = ticketMembreEquipe;
    }

    public List<Conseils> getConseils() {
        return conseils;
    }

    public void setConseils(List<Conseils> conseils) {
        this.conseils = conseils;
    }

}
