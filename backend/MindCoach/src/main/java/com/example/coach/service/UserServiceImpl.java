package com.example.coach.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.coach.entity.Categorie;
import com.example.coach.entity.User;
import com.example.coach.entity.UserDTO;
import com.example.coach.repo.CategoryRepository;
import com.example.coach.repo.UserRepository;






@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userepository;

	@Override
	public UserDTO saveUser(UserDTO u) {
		 // Encode the password before saving
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword); // Set the encoded password
        
        // Save the user and convert to DTO
        return convertEntityToDto(userepository.save(convertDtoToEntity(u)));
    }
	

	@Override
	public UserDTO updateUser(UserDTO u) {
		// TODO Auto-generated method stub
		return convertEntityToDto(userepository.save(convertDtoToEntity(u)));
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		userepository.delete(u);
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		userepository.deleteById(id);
	}

	@Override
	public UserDTO getUser(Long id) {
		// TODO Auto-generated method stub
		return convertEntityToDto(userepository.findById(id).get());
	}

	@Override
	public List<UserDTO> getAllusers() {
		// TODO Auto-generated method stub
		return userepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return userepository.findByUsername(username);
	}

	@Override
	public List<User> findByCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return userepository.findByCategorie(categorie);
	}

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserDTO convertEntityToDto(User user) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		return userDTO;
	}

	@Override
	public User convertDtoToEntity(UserDTO userDto) {
		// TODO Auto-generated method stub
		User user = new User();
		user = modelMapper.map(userDto, User.class);
		return user ;
	}

	@Override
	public List<User> findByCategorieIdCategorie(Long idCategorie) {
		// TODO Auto-generated method stub
		return userepository.findByCategorieIdCategorie(idCategorie);
	}
	
	
	
	
	
	@Override
    public User findByPassword(String password) {
        return userepository.findByPassword(password);
    }
	
	
	
	

	
	
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	
	
	

	
	 

	    @Autowired
	    private CategoryRepository categoryRepository;

	    

	
	
	

	
}

