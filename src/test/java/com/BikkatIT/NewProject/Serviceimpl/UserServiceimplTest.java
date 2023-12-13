package com.BikkatIT.NewProject.Serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.BikkatIT.NewProject.entity.User;
import com.BikkatIT.NewProject.payloads.UserDto;
import com.BikkatIT.NewProject.repository.UserRepository;
import com.BikkatIT.NewProject.serviceI.UserserviceI;
@SpringBootTest
class UserServiceimplTest {
	
	
	@MockBean
	private UserRepository userRepository;
	@Autowired
	private UserserviceI userserviceI;
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	User user;
	
	@BeforeEach
	public void init() {
		
		user=User.builder().name("balaji").email("rakh12322@gmail.com").password("abcde").about("i am the boss").build();
		
		 
	}
	
	
	
	@Test
	public void updateUserTest() {
		
		
		Integer userid = 8;
		UserDto userDto=new UserDto();
		
		
		
		userDto.setAbout("i am a docter");
		userDto.setEmail("v@gmail.com");
		userDto.setName("vaibhav");
		userDto.setPassword("bdbvgvdvv");
		
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(user));
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(userDto);
		
	UserDto updateUser = userserviceI.updateUser(userDto, userid);
	
	assertEquals(userDto.getName(), updateUser.getName());
		
		
		
	}

}
