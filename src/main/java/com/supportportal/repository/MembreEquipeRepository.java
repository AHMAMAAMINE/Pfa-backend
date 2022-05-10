package com.supportportal.repository;


import com.supportportal.domain.MembreEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembreEquipeRepository extends JpaRepository<MembreEquipe,Long> {

    public List<MembreEquipe> findByEquipeRef(String ref);

    public MembreEquipe findByCollaborateurCodeCollaborateur(String code);

    public int deleteByCollaborateurCodeCollaborateur(String code);

    List<MembreEquipe> findAll();
}
