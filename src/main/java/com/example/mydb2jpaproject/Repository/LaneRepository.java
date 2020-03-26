package com.example.mydb2jpaproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mydb2jpaproject.entity.Lane;

public interface LaneRepository extends JpaRepository<Lane, Long>
{
	List<Lane> findAll();
	Lane findByLogin(String login);
	
  
}

