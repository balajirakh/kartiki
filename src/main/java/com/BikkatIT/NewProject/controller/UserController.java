package com.BikkatIT.NewProject.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BikkatIT.NewProject.entity.User;
import com.BikkatIT.NewProject.payloads.ApiResponse;
import com.BikkatIT.NewProject.payloads.UserDto;
import com.BikkatIT.NewProject.serviceI.UserserviceI;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserserviceI userserviceI;

	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

		UserDto createUserdto = this.userserviceI.createUser(userDto);
		return new ResponseEntity<UserDto>(createUserdto, HttpStatus.CREATED);

	}

	@PutMapping("/{userid}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userid) {

		UserDto updateUser = this.userserviceI.updateUser(userDto, userid);

		return new ResponseEntity<UserDto>(updateUser, HttpStatus.CREATED);

	}

	@GetMapping("/{userid}")
	public ResponseEntity<UserDto> getuserbyId(@PathVariable Integer userid) {

		UserDto userById = this.userserviceI.getUserById(userid);

		return new ResponseEntity<UserDto>(userById, HttpStatus.OK);

	}

	@DeleteMapping("/{userid}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userid) {

		this.userserviceI.deleteUser(userid);

		return new ResponseEntity(new ApiResponse("user deleted succusfully", true, null), HttpStatus.OK);

	}

	@DeleteMapping("/")
	public ResponseEntity<ApiResponse> deleteAllusers() {
		this.userserviceI.deleteAllusers();
		return new ResponseEntity(new ApiResponse("delete all users succesfully ", true, null), HttpStatus.OK);

	}

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllusers() {
		return new ResponseEntity(this.userserviceI.getAllUsers(), HttpStatus.OK);

	}

}
