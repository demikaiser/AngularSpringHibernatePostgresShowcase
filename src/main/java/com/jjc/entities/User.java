package com.jjc.entities;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class User {

	@Id
	@GeneratedValue(generator="user_generator")
	@SequenceGenerator(
            name = "user_generator",
            sequenceName = "user_sequence",
            initialValue = 1000
    )
    private Long id;

    private String name;

    private String username;
    
    private String email;
    
    private String phone;
    
    private String website;

    /**
     * Default constructor.
     */
    public User() {
	}
 
    /**
     * Constructor with starter values.
     */
	public User(String name, String username, String email, String phone, String website) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.website = website;
	}

	/**
	 * Setters and getters.
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
 
}