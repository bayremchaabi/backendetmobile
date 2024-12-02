package com.example.coach.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "usernameUser", types = { User.class })
public interface projectionprod {
	
	public String getUsernameUser();


}
