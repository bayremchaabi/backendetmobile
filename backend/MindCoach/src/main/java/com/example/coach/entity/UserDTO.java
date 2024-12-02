package com.example.coach.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
	
	
	public UserDTO() {
	    // No-argument constructor
	}
    private Long id;
    private String username; // Ensure this field is declared
    private String email;
    private String password;
    private String nbTel;
    private String role;
    private Integer age;
    private Boolean status;

    // Private constructor to enforce the use of the builder
    private UserDTO(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
        this.nbTel = builder.nbTel;
        this.role = builder.role;
        this.age = builder.age;
        this.status = builder.status;
    }

    // Getters
    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getNbTel() { return nbTel; }
    public String getRole() { return role; }
    public Integer getAge() { return age; }
    public Boolean getStatus() { return status; }

    // Static inner Builder class
    public static class Builder {
        private Long id;
        private String username; // Ensure this field is declared
        private String email;
        private String password; 
        private String nbTel;
        private String role;
        private Integer age;
        private Boolean status;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }
        
        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder nbTel(String nbTel) {
            this.nbTel = nbTel;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }
        
        

        public Builder status(Boolean status) {
            this.status = status;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(this);
        }

		
    }

    // Static method to return a new Builder
    public static Builder builder() {
        return new Builder();
    }

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNbTel(String nbTel) {
		this.nbTel = nbTel;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	
}
	
	
	
	
	
	


