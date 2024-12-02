package com.example.coach.service;

import java.util.List;

import com.example.coach.entity.Categorie;
import com.example.coach.entity.User;
import com.example.coach.entity.UserDTO;


public interface UserService {
	UserDTO saveUser(UserDTO u);
	UserDTO updateUser(UserDTO u);
	void deleteUser(User u);
	 void deleteUserById(Long id);
	 UserDTO getUser(Long id);
	List<UserDTO> getAllusers();
	List<User> findByUsername(String username);
	List<User> findByCategorie (Categorie categorie);
	List<Categorie> getAllCategories();
	UserDTO convertEntityToDto (User user);
	User convertDtoToEntity(UserDTO userDto); 
	List<User> findByCategorieIdCategorie(Long idCategorie);
	User findByPassword(String password);
	
	
	
	
	
	
	
	
	
	
	

}
