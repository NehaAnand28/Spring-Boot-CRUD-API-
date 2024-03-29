package com.neha.springbootrestfulwebservices.repository;

import com.neha.springbootrestfulwebservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
