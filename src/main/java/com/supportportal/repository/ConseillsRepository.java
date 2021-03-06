package com.supportportal.repository;

import com.supportportal.domain.Conseils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConseillsRepository extends JpaRepository<Conseils,Long> {
     List<Conseils> findByMembreEquipeCollaborateurCodeCollaborateur(String code);

     List<Conseils> findAll();
     void deleteById(Long id);
    int deleteByTicketCode(String code);
    int deleteByMembreEquipeCollaborateurCodeCollaborateurAndMessageAndTicketCode(String code, String message, String codeticket);

    List<Conseils> findByTicketCode(String code);
}
