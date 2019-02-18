package com.jjc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jjc.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}