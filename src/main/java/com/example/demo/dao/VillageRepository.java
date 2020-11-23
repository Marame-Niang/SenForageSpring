package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Village;


@Repository
public interface VillageRepository extends JpaRepository<Village, Integer>{
	
}
