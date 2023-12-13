package com.BikkatIT.NewProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Builder
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "userdetails")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid", nullable = false, length = 100)
	private int id;
	@Column(name = "user_name")
	private String name;
	@Column(name = "user_email")
	private String email;
	@Column(name = "user_password")
	private String password;
	@Column(name = "about_user")
	private String about;
	
	

}
