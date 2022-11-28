package com.bway.springproject.rerpository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springproject.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserNameAndPassword(String userName, String password);

}
