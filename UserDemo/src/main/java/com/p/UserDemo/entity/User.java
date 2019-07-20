package com.p.UserDemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class corresponding to User Table
 * @author Pragya
 *
 */
@Entity
@Table(name="user")
public class User {

	/* Auto generated user id */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	/* User name */
	String name;
	
	/* Email id for the user*/
	String email;
	
	public User()
	{
		
	}
	
	/**
	 * Setter method for user id
	 * @param id
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}

	/**
	 * Getter method for user id
	 * @return id
	 */
	public Integer getId()
	{
		return id;
	}
	
	
	/**
	 * Setter method for user name
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Getter method for user name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Setter method for user email
	 * @param email
	 */
	public void setEmail(String email)
	{
		this.email= email;
	}
	
	/**
	 * Getter method for user email
	 * @return email
	 */
	public String getEmail()
	{
		return email;
	}
}
