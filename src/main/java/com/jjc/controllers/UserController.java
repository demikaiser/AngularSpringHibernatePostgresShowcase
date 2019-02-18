package com.jjc.controllers;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjc.entities.User;
import com.jjc.repositories.UserRepository;
import com.jjc.utilities.FetchData;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/randomusers")
	public List<User> randomUsers() {
		
		// Get a record from the remote users API.
		JSONObject jsonObject = null;
		try {
    		jsonObject = FetchData.getRandomUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Make a record from the fetched JSON.
		String name = (String) jsonObject.get("name");
		String username = (String) jsonObject.get("username");
		String email = (String) jsonObject.get("email");
		String phone = (String) jsonObject.get("phone");
		String website = (String) jsonObject.get("website");
		userRepository.save(new User(name, username, email, phone, website));

		return userRepository.findAll();
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		return userRepository.findById(id);
	}

	@DeleteMapping("/user/{id}")
	public boolean deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
		return true;
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

}