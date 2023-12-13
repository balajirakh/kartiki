package com.BikkatIT.NewProject.Serviceimpl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkatIT.NewProject.entity.User;
import com.BikkatIT.NewProject.exceptions.ResourceNotFoundException;
import com.BikkatIT.NewProject.payloads.UserDto;
import com.BikkatIT.NewProject.repository.UserRepository;
import com.BikkatIT.NewProject.serviceI.UserserviceI;

@Service
public class UserServiceimpl implements UserserviceI {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.DtotoUser(userDto);
		User saveuser = this.userRepository.save(user);
		return this.UsertoDto(saveuser);

	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userid) {

		User user = this.userRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userid));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());

		User updateduser = this.userRepository.save(user);

		UserDto userDto1 = this.UsertoDto(updateduser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userid) {
		User user = this.userRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userid));

		return this.UsertoDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepository.findAll();
		List<UserDto> userDtolist = users.stream().map(user -> this.UsertoDto(user)).collect(Collectors.toList());
		return userDtolist;
	}

	@Override
	public void deleteUser(Integer userid) {
		User user = this.userRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userid));

		this.userRepository.delete(user);
	}

	@Override
	public void deleteAllusers() {

		List<User> findAll = this.userRepository.findAll();
		List<UserDto> userDtolist = findAll.stream().map(user -> this.UsertoDto(user)).collect(Collectors.toList());

		this.userRepository.deleteAll();

	}

	public User DtotoUser(UserDto userDto) {

		
		
		User user = this.modelMapper.map(userDto, User.class);
		
//		User user =new User();
//		user.setAbout(userDto.getAbout());
//		user.setEmail(userDto.getEmail());
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setPassword(userDto.getPassword());

		return user;
	}

	public UserDto UsertoDto(User user) {

		UserDto userDto = modelMapper.map(user,UserDto.class);

		//for manually set.
//      		
//		userDto.setAbout(user.getAbout());
//		userDto.setEmail(user.getEmail());
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setPassword(user.getPassword());

		return userDto;

	}

}
