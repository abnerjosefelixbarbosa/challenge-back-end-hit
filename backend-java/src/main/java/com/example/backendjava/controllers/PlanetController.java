package com.example.backendjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendjava.domain.dtos.requests.PlanetRequest;
import com.example.backendjava.domain.dtos.responses.PlanetResponse;
import com.example.backendjava.interfaces.IPlanetService;

@RestController
@RequestMapping("/api/planets")
public class PlanetController 
{
	@Autowired
	private IPlanetService service;
	
	@PostMapping
	public ResponseEntity<PlanetResponse> addPlanet(PlanetRequest request) 
	{
		PlanetResponse response = service.addPlanet(request);
		return ResponseEntity.status(201).body(response);
	}

	@GetMapping
	public ResponseEntity<Page<PlanetResponse>> listPlanet(Pageable pageable) 
	{
		Page<PlanetResponse> responses = service.listPlanet(pageable);
		return ResponseEntity.status(200).body(responses);
	}

	@GetMapping("/name")
	public ResponseEntity<PlanetResponse> searchPlanetByName(@RequestParam String name) 
	{
		PlanetResponse response = service.searchPlanetByName(name);
		return ResponseEntity.status(200).body(response);
	}

	@GetMapping("/id")
	public ResponseEntity<PlanetResponse> searchPlanetById(@RequestParam String id) 
	{
		PlanetResponse response = service.searchPlanetById(id);
		return ResponseEntity.status(200).body(response);
	}

	@DeleteMapping("/id")
	public ResponseEntity<Void> removePlanetById(@RequestParam String id) 
	{
		service.removePlanetById(id);
		return ResponseEntity.status(204).body(null);
	}
}