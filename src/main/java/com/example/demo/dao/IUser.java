package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.User;

@Repository
public interface IUser<T> extends JpaRepository<User, Integer>{
	@Query("SELECT u FROM User u WHERE u.email=:email AND u.password=:password")
	public User getUserByEmailAndPassword(@Param("email") String email, @Param("password") String  password);
}
