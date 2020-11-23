package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Roles;

@Repository
public interface IRoles extends JpaRepository<Roles, Integer>{

}
