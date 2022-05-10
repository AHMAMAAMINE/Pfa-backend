package com.supportportal.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    @OneToMany(mappedBy = "equipe")
    private List<MembreEquipe> membres;
    private String libelle;
    private String code;
    @OneToOne
    private MembreEquipe chefEquipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public List<MembreEquipe> getMembres() {
        return membres;
    }

    public void setMembres(List<MembreEquipe> membres) {
        this.membres = membres;
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

    public MembreEquipe getChefEquipe() {
        return chefEquipe;
    }

    public void setChefEquipe(MembreEquipe chefEquipe) {
        this.chefEquipe = chefEquipe;
    }
}
