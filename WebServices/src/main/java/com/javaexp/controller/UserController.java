package com.javaexp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexp.entity.User;
import com.javaexp.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public void createUser(@RequestBody User user) {
		log.info("UserController :: createUser {}", user.getEmail() );
		userService.createUser(user);
		
	}
	@GetMapping("{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.findUserById(id);
	}
	@GetMapping
	public List<User> getAll(){
		List<User>user = userService.fetchAllUser();
		return user;
	}
	@PutMapping("{id}")
	public void updateUser(@PathVariable Long id,@RequestBody User user) {
		userService.updateUser(id, user);
	}
	@PatchMapping("changpwd/{id}")
	public void updatePassword(@PathVariable Long id,@RequestBody User user) {
		userService.updatePassword(id,user);
	}
	@DeleteMapping
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}
