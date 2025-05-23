package com.capgemini.project.services;

import java.util.List;

import com.capgemini.project.entities.User;


public interface UserService {
	
	public List<User> listAllUser();
	
	public void deleteUser(Long id);
	
	public User createUser(User user);
	
	public User findUserById(Long id);
	
	public User updateUser(Long id, User user);
	
	public User patchUser(Long id, User user);
	
	public long userCount(String userType);
	
	boolean existsByUserName(String username);

	boolean existsByEmail(String email);

	User findByUserNameOrEmail(String username, String email);
	
}
