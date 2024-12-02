package com.example.coach.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.coach.entity.User;
import com.example.coach.entity.UserDTO;
import com.example.coach.entity.UserRegistarionDTO;
import com.example.coach.repo.UserRepository;
import com.example.coach.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	@Autowired
	UserService s;
	 @Autowired 
	UserRepository userRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<UserDTO> getAllUsers() {
		return s.getAllusers();
	}
	
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
	
	public UserDTO getUserById(@PathVariable("id") Long id) {
	return s.getUser(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public  UserDTO createUser(@RequestBody UserDTO userDTO) {
	return s.saveUser(userDTO);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") Long id)
	{
	s.deleteUserById(id);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public UserDTO updateProduit(@RequestBody UserDTO userDTO) {
	return s.updateUser(userDTO);
	}
	@RequestMapping(value="/prodscat/{idCategorie}",method = RequestMethod.GET)
	public List<User> getProduitsByCatId(@PathVariable("idCategorie") Long idCategorie) {
	return s.findByCategorieIdCategorie(idCategorie);
	}
	 @GetMapping("/searchByEmail")
	    public ResponseEntity<User> findByEmail(@RequestParam String email) {
	        Optional<User> user = userRepo.findByEmail(email);

	        return user.map(ResponseEntity::ok) // Renvoie l'utilisateur directement
	                   .orElseGet(() -> ResponseEntity.notFound().build());
	    }
	 
	 
	 
	 
	 

	 @PostMapping("/login")
		public UserDTO loginUser(@RequestBody UserDTO loginDTO) {
		    List<User> userList = s.findByUsername(loginDTO.getUsername());
		    UserDTO authenticatedUser = null;

		    if (!userList.isEmpty()) {
		        for (User user : userList) {
		            if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
		                authenticatedUser = UserDTO.builder()
		                    .id(user.getId())
		                    .username(user.getUsername())
		                    .password(user.getPassword())
		                    .email(user.getEmail())
		                    .age(user.getAge())
		                    .role(user.getRole()) // Include role in the response
		                    .status(user.getStatus())
		                    .build();
		                break;
		            }
		        }
		    }
		    if (authenticatedUser == null) {
		        throw new RuntimeException("Invalid username or password");
		    }
		    return authenticatedUser;
		}

		
		
		
		
		
		@Autowired
	    private PasswordEncoder passwordEncoder;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		@RequestMapping(value="/{id}",method = RequestMethod.PUT)
		public UserDTO updateUser(@PathVariable Long id,@RequestBody UserDTO userDTO) {
			userDTO.setId(id);
		return s.updateUser(userDTO);
		}
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
	 
}
	