package com.jjc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jjc.entities.User;
import com.jjc.repositories.UserRepository;

@SpringBootApplication
public class CrudBackendApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * The main entry of the program.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrudBackendApplication.class, args);
	}

	/**
	 * This line will be executed when the server starts. Currently there are some
	 * example records to test the database and the REST APIs. In the production environment,
	 * delete this or use it to setup the basic runtime setup.
	 */
	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("name1", "username1", "email1", "phone1", "website1"));
		userRepository.save(new User("name2", "username2", "email2", "phone2", "website2"));
		userRepository.save(new User("name3", "username3", "email3", "phone3", "website3"));
	}
}