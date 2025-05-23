package com.capgemini.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.project.entities.User;
import com.capgemini.project.exceptions.UserNotFoundException;
import com.capgemini.project.repositories.UserRepo;

@Service
public class UserServiceImp implements UserService{
	
	private final UserRepo repo;

	public UserServiceImp(UserRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<User> listAllUser() {
		return repo.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		if (!(repo.existsById(id))) {
			throw new UserNotFoundException("Can't Delete. User not found with ID: " + id);
		}
		repo.deleteById(id);
	}

	@Override
	public User createUser(User user) {
		return repo.save(user);
	}

	@Override
	public User findUserById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
	}

	@Override
	public User updateUser(Long id, User user) {
		User existing = repo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
		existing.setEmail(user.getEmail());
		existing.setName(user.getName());
		existing.setPassword(user.getPassword());
		existing.setPhone(user.getPhone());
		existing.setUserType(user.getUserType());
		return repo.save(existing);
	}

	@Override
	public User patchUser(Long id, User user) {
		User existing = repo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
		if (user.getEmail() != null) {			
			existing.setEmail(user.getEmail());
		}
		if (user.getName() != null) {			
			existing.setName(user.getName());
		}
		if (user.getPassword() != null) {			
			existing.setPassword(user.getPassword());
		}
		if (user.getPhone() != 0) {			
			existing.setPhone(user.getPhone());
		}
		if(user.getUserType() != null) {			
			existing.setUserType(user.getUserType());
		}
		return repo.save(existing);
	}
	
	@Override
	public long userCount(String userType) {
		return repo.userCount(userType);
	}
	
	@Override
	public boolean existsByUserName(String username) {
		return repo.existsByName(username);
	}

	@Override
	public boolean existsByEmail(String email) {
		return repo.existsByEmail(email);
	}
	
	@Override
	public User findByUserNameOrEmail(String username, String email) {
		return repo.findByNameOrEmail(username, email)
				.orElseThrow(()->new UserNotFoundException("Username or Email not Found !"));
	}

}
