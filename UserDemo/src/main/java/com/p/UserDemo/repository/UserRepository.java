package com.p.UserDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p.UserDemo.entity.User;


/**
 * JPA Repository interface for entity User
 * @author Pragya
 *
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer>{

	
}
