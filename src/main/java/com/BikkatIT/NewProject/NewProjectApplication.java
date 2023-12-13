package com.BikkatIT.NewProject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.BikkatIT.NewProject.entity.User;

@SpringBootApplication
public class NewProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewProjectApplication.class, args);
	
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
		
		
		
	}

	}


