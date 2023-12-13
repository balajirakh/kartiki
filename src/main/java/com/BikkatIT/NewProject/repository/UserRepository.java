package com.BikkatIT.NewProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkatIT.NewProject.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
