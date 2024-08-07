package com.example.backendjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendjava.domain.dtos.requests.PlanetRequest;
import com.example.backendjava.domain.dtos.responses.PlanetResponse;
import com.example.backendjava.domain.usecase.IPlanetUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/planets")
public class PlanetController {
	@Autowired
	private IPlanetUseCase planetUseCase;

	@PostMapping("/add-planet")
	public ResponseEntity<PlanetResponse> addPlanet(@RequestBody @Valid PlanetRequest request) {
		PlanetResponse response = planetUseCase.addPlanet(request);
		return ResponseEntity.status(201).body(response);
	}

	@GetMapping("/list-planets")
	public ResponseEntity<Page<PlanetResponse>> listPlanets(Pageable pageable) {
		Page<PlanetResponse> responses = planetUseCase.listPlanet(pageable);
		return ResponseEntity.status(200).body(responses);
	}

	@GetMapping("/search-planet-by-name")
	public ResponseEntity<PlanetResponse> searchPlanetByName(@RequestParam String name) {
		PlanetResponse response = planetUseCase.searchPlanetByName(name);
		return ResponseEntity.status(200).body(response);
	}

	@GetMapping("/search-planet-by-id")
	public ResponseEntity<PlanetResponse> searchPlanetById(@RequestParam String id) {
		PlanetResponse response = planetUseCase.searchPlanetById(id);
		return ResponseEntity.status(200).body(response);
	}

	@DeleteMapping("/remove-planet-by-id")
	public ResponseEntity<Void> removePlanetById(@RequestParam String id) {
		planetUseCase.removePlanetById(id);
		return ResponseEntity.status(204).body(null);
	}
}