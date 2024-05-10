package com.camoutech.repository;

import com.camoutech.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "cat")
public interface CategoryRepositiry extends JpaRepository<Categorie, Long> {
}
