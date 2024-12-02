package com.example.coach.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.InheritanceType;




@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String username;
private String password;
private String email;
private Integer nbTel;
private String role;
private Integer age;
private Boolean status;
@ManyToOne
private Categorie categorie;

public User(String username, String password, String email,Integer nbTel, String role, Integer age, Boolean status) {
	super();
	this.username = username;
	this.password = password;
	this.email = email;
	this.nbTel=nbTel;
	this.role = role;
	this.age = age;
	this.status = status;
}

	

public User() {
	super();
	// TODO Auto-generated constructor stub
}


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Integer getnbTel() {
	return nbTel;
}
public void setnbTel(Integer nbTel) {
	this.nbTel = nbTel;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public Boolean getStatus() {
	return status;
}
public void setStatus(Boolean status) {
	this.status = status;
}
public Categorie getCategorie() {
	return categorie;
}

public void setCategorie(Categorie categorie) {
	this.categorie = categorie;
}




















	




























}