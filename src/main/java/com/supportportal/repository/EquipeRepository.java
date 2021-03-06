package com.supportportal.repository;

import com.supportportal.domain.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe,Long> {
     Equipe findByLibelle(String libelle);

     Equipe findByChefEquipeCollaborateurCodeCollaborateur(String Code);

     Equipe findByCode(String code);

     Equipe findByRef(String ref);

     int deleteByRef(String ref);

     List<Equipe> findAll();
}
