package com.parul.BrowserExtensionStore.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parul.BrowserExtensionStore.Entity.User;
import com.parul.BrowserExtensionStore.Repository.UserRepo;
import com.parul.BrowserExtensionStore.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepository;
	
	public UserServiceImpl(UserRepo userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public User save(UserRegistrationDto registrationDto) {
	    User user = new User(null, 
	                         registrationDto.getFirstName(), 
	                         registrationDto.getLastName(), 
	                         registrationDto.getEmail(), 
	                         registrationDto.getPassword());
	    return userRepository.save(user);
	}


}
