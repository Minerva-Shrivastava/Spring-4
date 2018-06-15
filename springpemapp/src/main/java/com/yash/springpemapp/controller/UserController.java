package com.yash.springpemapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.springpemapp.domain.User;
import com.yash.springpemapp.exception.BlockUserException;
import com.yash.springpemapp.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	//@RequestMapping(value = "/users" ,method= RequestMethod.GET)
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getUserList();
	}
	
	@PostMapping(value = "/users")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		userService.register(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<User> login(@RequestBody User user) {
		try {
			user = userService.login(user.getLoginName(), user.getPassword());
		} catch (BlockUserException e) {
			e.getMessage();
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
			}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping(value = "/userStatus")
	public ResponseEntity<User> changeLoginStatus(@RequestBody User user){
		userService.changeLoginStatus(user.getUserId(), user.getStatus());
		return new ResponseEntity<User>(HttpStatus.OK);
	} 
	
	@PutMapping(value = "/user")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		userService.update(user);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/users/{id}")
	public ResponseEntity getUser(@PathVariable("id") Integer id) {

		User user = userService.getUserById(id);
		if (user == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping(value = "/users/{propertyName}/{propertyValue}")
	public List<User> searchByProperty(@PathVariable("propertyName") String propertyName, @PathVariable("propertyValue") String propertyValue){
		return userService.findByProperty(propertyName, propertyValue);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Integer> deleteUserById(@PathVariable Integer id) {
		userService.delete(id);
		return new ResponseEntity<Integer>(id, HttpStatus.OK);
	}
	
	@DeleteMapping("/users")
	public ResponseEntity<User> deleteUser(@RequestBody User user) {
		userService.delete(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
