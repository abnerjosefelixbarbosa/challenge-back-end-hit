package com.example.backendjava.infra.mappers;

import org.springframework.stereotype.Component;

import com.example.backendjava.domain.dtos.requests.PlanetRequest;
import com.example.backendjava.domain.dtos.responses.PlanetResponse;
import com.example.backendjava.infra.entities.Planet;

@Component
public class PlanetMapper {

	
	public PlanetResponse toPlanetResponse(Planet planet) {
		return PlanetResponse
				.builder()
				.id(planet.getId())
				.name(planet.getName())
				.climate(planet.getClimate())
				.terrain(planet.getTerrain())
				.build();
	}
	
	public Planet toPlanet(PlanetRequest request) {
		return Planet
				.builder()
				.name(request.getName())
				.climate(request.getClimate())
				.terrain(request.getTerrain())
				.build();
	}
	
}
