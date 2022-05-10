package com.supportportal.repository;

import com.supportportal.domain.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet,Long> {
    Projet findByRef(String ref);
    List<Projet> findAll();
    int deleteByRef(String ref);

}
