package com.example.mydb2jpaproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mydb2jpaproject.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long>
{
  List<Status> findAll();
}

