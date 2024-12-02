package com.example.coach.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Coach extends User {
    private String expertise;
    private Integer yearsOfExperience;

    public Coach() {
        super();
    }

    public Coach(String username, String password, String email, Integer nbTel, String role, Integer age, Boolean status, Categorie categorie, String expertise, Integer yearsOfExperience) {
        super(username, password, email, nbTel, role, age, status);
        this.expertise = expertise;
        this.yearsOfExperience = yearsOfExperience;
        this.setCategorie(categorie);
        
    }

    public String getExpertise() {
      return expertise;
    }

    public void setExpertise(String expertise) {
      this.expertise = expertise;
    }

    public Integer getYearsOfExperience() {
      return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
      this.yearsOfExperience = yearsOfExperience;
    }
    
}
