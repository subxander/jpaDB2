package com.example.mydb2jpaproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mydb2jpaproject.Repository.StatusRepository;
import com.example.mydb2jpaproject.entity.Status;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class StatusResource {

	@Autowired
	StatusRepository repo;


	@RequestMapping("/retrieveAllStatus")
	public List<Status> retrieveAllStatus() {
		System.out.println("Retrieve All Status");
		return repo.findAll();
	}

	@GetMapping("/retrieveStatus/{id}")
	public Status retrieveStatusById(@PathVariable long id) {
		System.out.println("HERE WE ARE ID: " + id);
		return repo.findById(id).get();
	}

	
	@PutMapping("/updateStatus")
	public ResponseEntity<Status> updateStatus(@RequestBody Status status) {
		System.out.println("IN Update FUNCTION: " + status.getLane());
		repo.save(status);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@DeleteMapping("/deleteStatus/{id}")
	public ResponseEntity<Void> deleteStatus(@PathVariable long id) {
		System.out.println("IN DELETE FUNCTION: " + id);
		// JPA delete returns nothing so just returning no content
		repo.deleteById(id);

		return ResponseEntity.noContent().build();

	}

//	@PostMapping("/createReservation")
//	public ResponseEntity<Void> createTodo(@RequestBody Status status) {
//		System.out.println("IN CREATE FUNCTION: " + status.getSTATUS());
//		//status.setUSERID(status.getUSERID());
//
//		//status createdTodo = repo.save(status);
//
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId())
//				.toUri();
//
//		System.out.println("URI : " + uri);
//		return ResponseEntity.created(uri).build();
//	}

	}
