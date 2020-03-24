package com.example.mydb2jpaproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mydb2jpaproject.Repository.JpaRepository;
import com.example.mydb2jpaproject.Repository.ThingsInsertRepository;
import com.example.mydb2jpaproject.entity.Things;

@RestController
public class Example {

	@Autowired
	JpaRepository repo;
	
	@Autowired
	ThingsInsertRepository insertRepo;

	@RequestMapping("/findall")
	public @ResponseBody ResponseEntity<String> findAll() {
		List<String> list = new ArrayList<>();
		list.add("Table data...");
		for (Things things : repo.findAll()) {
			list.add(things.toString());
		}
		return new ResponseEntity<String>(list.toString(), HttpStatus.OK);
	}
	
	@GetMapping("/findbyid/{id}")
	public Things getTodos( @PathVariable long id) {
		return repo.findById(id).get();
	}

	@PutMapping("/update")
	public ResponseEntity<Things> updateTodo(@RequestBody Things thing) {
		repo.save(thing);
		return new ResponseEntity<Things>(thing, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable long id) {

		// JPA delete returns nothing so just returning no content
		repo.deleteById(id);

		return ResponseEntity.noContent().build();

	}
	
	@PostMapping("/create")
	public ResponseEntity<Void> createTodo(@RequestBody Things thing) {
		insertRepo.insertWithQuery(thing);
		return ResponseEntity.noContent().build();
	}

}
