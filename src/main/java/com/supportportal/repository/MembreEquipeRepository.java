package com.supportportal.repository;


import com.supportportal.domain.MembreEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembreEquipeRepository extends JpaRepository<MembreEquipe,Long> {

     List<MembreEquipe> findByEquipeRef(String ref);

     MembreEquipe findByCollaborateurCodeCollaborateur(String code);

     int deleteByCollaborateurCodeCollaborateur(String code);

    List<MembreEquipe> findAll();
}
