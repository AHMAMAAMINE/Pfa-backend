package com.supportportal.repository;

import com.supportportal.domain.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollaborateurRepository extends JpaRepository<Collaborateur,Long> {
     Collaborateur findByCodeCollaborateur(String codeCollaborateur);

     Collaborateur findByUserUsername(String username);

     int deleteByCodeCollaborateur(String codeCollaborateur);

    List<Collaborateur> findAll();
}
