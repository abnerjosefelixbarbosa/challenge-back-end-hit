package com.example.backendjava.infra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.backendjava.adapters.IPlanetGateWay;
import com.example.backendjava.domain.dtos.requests.PlanetRequest;
import com.example.backendjava.domain.dtos.responses.PlanetResponse;
import com.example.backendjava.infra.entities.Planet;
import com.example.backendjava.infra.mappers.PlanetMapper;
import com.example.backendjava.infra.repositories.IPlanetRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PlanetService implements IPlanetGateWay {
	@Autowired
	private IPlanetRepository planetRepository;
	@Autowired
	private SwapiService swapiService;
	@Autowired
	private PlanetMapper planetMapper;

	public PlanetResponse addPlanet(PlanetRequest request) {
		Planet planet = planetMapper.toPlanet(request);
		validatePlanet(request);

		Long numberFilms = swapiService.getNumberAppearancesFilms(request);

		planet.setApparition(numberFilms);
		return planetMapper.toPlanetResponse(planetRepository.save(planet));
	}

	public Page<PlanetResponse> listPlanet(Pageable pageable) {
		return planetRepository.findAll(pageable).map(planetMapper::toPlanetResponse);
	}

	public PlanetResponse searchPlanetByName(String name) {
		return planetRepository.findByName(name).map((val) -> planetMapper.toPlanetResponse(val))
				.orElseThrow(() -> new EntityNotFoundException("name not found"));
	}

	public PlanetResponse searchPlanetById(String id) {
		return planetRepository.findById(id).map((val) -> planetMapper.toPlanetResponse(val))
				.orElseThrow(() -> new EntityNotFoundException("id not found"));
	}

	public void removePlanetById(String id) {
		Planet planet = planetRepository
		.findById(id)
	    .orElseThrow(() -> new EntityNotFoundException("id not found"));
		
		planetRepository.delete(planet);
	}

	private void validatePlanet(PlanetRequest request) {
		if (planetRepository.existsByName(request.getName())) {
			throw new RuntimeException("name exists");
		}
	}
}