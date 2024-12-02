package com.example.coach.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.coach.entity.Categorie;

@RepositoryRestResource(path = "cat")
/*@CrossOrigin*/
public interface CategoryRepository extends JpaRepository<Categorie, Long> {

}