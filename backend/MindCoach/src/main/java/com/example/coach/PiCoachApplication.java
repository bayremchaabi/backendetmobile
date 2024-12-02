package com.example.coach;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.coach.entity.Categorie;
import com.example.coach.entity.User;

@SpringBootApplication
public class PiCoachApplication {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(PiCoachApplication.class, args);
	}
	 public void run(String... args) throws Exception {
		    repositoryRestConfiguration.exposeIdsFor(User.class,Categorie.class);
		    }
		    @Bean
		    public ModelMapper modelMapper()
		    {
		    return new ModelMapper();
		    }
		    

}
