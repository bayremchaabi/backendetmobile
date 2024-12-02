package com.example.coach.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;

@PrePersist
@Entity

@PrimaryKeyJoinColumn(name = "coach_id")
public class pendingCoach extends Coach {

    private String qualifications;
    private boolean processed = false;
    private String statuss="pending";
    private String motivationmsg;

    // Default constructor
    public pendingCoach() {
        super();
    }

    // Constructor to initialize all fields
    public pendingCoach(String username, String password, String email, Integer nbTel, String role, Integer age, Boolean status, Categorie categorie, String specialty, Integer experienceYears, String qualifications, boolean processed,String motivationmsg,String statuss) {
        super(username, password, email, nbTel, role, age, status, categorie, specialty, experienceYears);
        this.qualifications = qualifications;
        this.motivationmsg=motivationmsg;
        this.processed = processed;
        this.statuss=statuss;
    }

    // Getters and setters
    public String getQualifications() {
        return qualifications;
    }
     
    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public String getMotivationmsg() {
      return motivationmsg;
    }

    public void setMotivationmsg(String motivationmsg) {
      this.motivationmsg = motivationmsg;
    }

    public String getStatuss() {
      return statuss;
    }

    public void setStatuss(String statuss) {
      this.statuss = statuss;
    }
    
}