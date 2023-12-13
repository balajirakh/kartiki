package com.BikkatIT.NewProject.serviceI;

import java.util.List;

import com.BikkatIT.NewProject.payloads.UserDto;

public interface UserserviceI {

	UserDto createUser(UserDto userDto);

	UserDto updateUser(UserDto userDto, Integer userid);

	UserDto getUserById(Integer userid);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userid);

	void deleteAllusers();

}
