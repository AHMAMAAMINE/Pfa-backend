package com.supportportal.repository;

import com.supportportal.domain.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe,Long> {
    public Equipe findByLibelle(String libelle);

    public Equipe findByChefEquipeCollaborateurCodeCollaborateur(String Code);

    public Equipe findByCode(String code);

    public Equipe findByRef(String ref);

    public int deleteByRef(String ref);

    public List<Equipe> findAll();
}
