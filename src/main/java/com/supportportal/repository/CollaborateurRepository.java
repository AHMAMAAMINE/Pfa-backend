package com.supportportal.repository;

import com.supportportal.domain.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollaborateurRepository extends JpaRepository<Collaborateur,Long> {
    public Collaborateur findByCodeCollaborateur(String codeCollaborateur);

    public int deleteByCodeCollaborateur(String codeCollaborateur);

    List<Collaborateur> findAll();
}
