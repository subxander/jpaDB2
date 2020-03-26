package com.example.mydb2jpaproject.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.mydb2jpaproject.Repository.LaneRepository;
import com.example.mydb2jpaproject.entity.Lane;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LaneResource {

	@Autowired
	LaneRepository repo;

	@RequestMapping("/alllanes")
	public List<Lane> findAll() {
		System.out.println("HERE WE ARE");
		return repo.findAll();
	}

	@GetMapping("/retrieveLane/{login}")
	public Lane getLane(@PathVariable String login) {
		System.out.println("HERE WE ARE ID: " + login);
		return repo.findByLogin(login);
	}

	@PutMapping("/updatelane")
	public ResponseEntity<Lane> updateTodo(@RequestBody Lane lane) {
		System.out.println("IN Update FUNCTION: " + lane.getLogin() + " "  + lane.getLane());
		repo.save(lane);
		return new ResponseEntity<Lane>(lane, HttpStatus.OK);
	}

	@DeleteMapping("/deletelane/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable long id) {
		System.out.println("IN DELETE FUNCTION: " + id);
		// JPA delete returns nothing so just returning no content
		repo.deleteById(id);

		return ResponseEntity.noContent().build();

	}

	@PostMapping("/createReservation")
	public ResponseEntity<Void> createTodo(@RequestBody Lane lane) {
	//	System.out.println("IN CREATE FUNCTION: " + lane.getUSERID() + " "  + lane.getLANE());
	//	lane.setUSERID(lane.getUSERID());

		Lane createdTodo = repo.save(lane);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId())
				.toUri();

		System.out.println("URI : " + uri);
		return ResponseEntity.created(uri).build();
	}
}
