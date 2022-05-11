package com.supportportal.service;

import com.supportportal.domain.Projet;

import java.util.List;

public interface ProjetService {
    Projet findByRef(String ref);

    List<Projet> findAll();

    int deleteByRef(String ref);

    int save(Projet projet);

    Projet update(Projet projet);

}
