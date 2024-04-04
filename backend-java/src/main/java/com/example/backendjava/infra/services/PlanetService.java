package com.example.backendjava.infra.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.backendjava.adapters.PlanetAdapeter;
import com.example.backendjava.domain.dtos.requests.PlanetRequest;
import com.example.backendjava.domain.dtos.responses.PlanetResponse;
import com.example.backendjava.infra.entities.Planet;
import com.example.backendjava.infra.repositories.PlanetRepository;
import com.example.backendjava.interfaces.IPlanetService;

import jakarta.persistence.EntityNotFoundException;


@Service
public class PlanetService implements IPlanetService 
{
	@Autowired
	private PlanetRepository repository;
	@Autowired
	private PlanetAdapeter adapeter;
	@Autowired
	private SwapiService service;

	public PlanetResponse addPlanet(PlanetRequest request) 
	{
		adapeter.addPlanet(request);
		Planet planet = new Planet(request);
		validatePlanet(request);
		
		service.getResponses();
		
		planet.setApparition(1L);
		planet = repository.save(planet);
		return new PlanetResponse(planet);
	}

	public Page<PlanetResponse> listPlanet(Pageable pageable) 
	{
		adapeter.listPlanet(pageable);
		return repository.findAll(pageable).map(PlanetResponse::new);
	}

	public PlanetResponse searchPlanetByName(String name) 
	{
		adapeter.searchPlanetByName(name);
		Planet planet = repository.findByName(name)
				.orElseThrow(() -> new EntityNotFoundException("name not found"));
		return new PlanetResponse(planet);
	}

	public PlanetResponse searchPlanetById(String id) 
	{
		adapeter.searchPlanetByName(id);
		Planet planet = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("id not found"));
		return new PlanetResponse(planet);
	}

	public void removePlanetById(String id) 
	{
		repository.deleteById(id);
	}
	
	private void validatePlanet(PlanetRequest request) 
	{
		if (repository.existsByName(request.getName())) throw new RuntimeException("name exists");
	}
}