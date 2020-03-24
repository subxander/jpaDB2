package com.example.mydb2jpaproject.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.example.mydb2jpaproject.entity.Things;

public interface JpaRepository extends CrudRepository<Things, Long>
{
  List<Things> findByName(String name);
  Iterable<Things> findAll();
}

