package com.AuthService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AuthService.Model.User;


public interface userRepository extends JpaRepository<User, Integer>{

}
