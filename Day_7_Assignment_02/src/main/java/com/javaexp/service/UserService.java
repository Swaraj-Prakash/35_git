package com.javaexp.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaexp.entity.User;
import com.javaexp.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void createUser(@RequestBody User user) {
		log.info("UserService :: createUser {} {}",user.getUserName(),user.getEmail());
		userRepository.save(user);
		log.info("User successfully save in DB");
	}
	public List<User> fetchAllUser() {
		List<User>userslist= userRepository.findAll();
		List<User> result=userslist.stream().sorted(Comparator.comparing(User::getUserName)).toList();
		return result;
	}
	public User findUserById(Long id) {
		return userRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("User Not Found"));
	}
	public void updateUser(Long id, User user) {
		log.info("UserService :: updateUser {} {}",user.getUserName(),user.getEmail());
		User dbUser = findUserById(id);
		dbUser.setEmail(user.getEmail());
		dbUser.setPassword(user.getPassword());
		dbUser.setUserName(user.getUserName());	
		userRepository.save(dbUser);
		
		log.info("User Update Successfully");
	}
	//hard delete
	public void deleteUser(Long id) {
		if(userRepository.existsById(id)) {
			userRepository.deleteById(id);
		}else {
			throw new RuntimeException("User not found");
		}
		
	}
	//hard delete (permanetly)
	public void deleteUserById(Long id) {
		User dbUser=findUserById(id);
		userRepository.delete(dbUser);
	}
	public void updatePassword(Long id, User user) {
		
		log.info("UserService :: updateUserPassword {} {}",user.getUserName(),user.getEmail());
		User dbUser = findUserById(id);
		dbUser.setPassword(user.getPassword());
		userRepository.save(dbUser);
		
		log.info("User UpdatePassword Successfully");
	}
	
	
	
}
