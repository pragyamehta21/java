package com.p.UserDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p.UserDemo.entity.User;
import com.p.UserDemo.repository.UserRepository;


/**
 * Rest Controller for User requests
 * @author Pragya
 *
 */
@RestController
@RequestMapping("/demo")
/* To allow requests from angular app*/
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	/**
	 * Process GET request ("/list") for list of all users
	 * @return list of all users from the database
	 */
	@GetMapping("/list")
	public List<User> getAllUsers()
	{
		List<User> userlist = userRepository.findAll();
		return userlist;
	}
	
	/**
	 * Process GET request("/userDetail/id") to get User Object corresponding to specific user id ("/userDetail/id")
	 * @param id : Id from requested URL path
	 * @return User object corresponding to specified id
	 */
	@GetMapping("/userDetail/{id}")
	public User getUser(@PathVariable("id") int id)
	{
		User user = userRepository.findById(id).orElse(null);
		return user;
	}
	
	/**
	 * Process POST request ("/saveUser") to save new or updated User to the database
	 * @param user User object to be saved
	 * @return Updated User object from the database.
	 */
	@PostMapping("/saveUser")
	public User addUser(@RequestBody User user) {
		
		userRepository.save(user);
		return user;
	}

	/**
	 * Process Get request to delete a user from database
	 * @param id - user id to be deleted
	 * @return - 'Deleted' if delete successful, else 'Error'
	 */
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") int id)
	{
		User user = userRepository.findById(id).orElse(null);
		if(user!=null)
		{
			userRepository.delete(user);
			return "Deleted";
		}
		else
		{
			return "Error";
		}
	}

}

