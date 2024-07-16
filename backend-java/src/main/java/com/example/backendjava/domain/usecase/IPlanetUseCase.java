package com.example.backendjava.domain.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.backendjava.domain.dtos.requests.PlanetRequest;
import com.example.backendjava.domain.dtos.responses.PlanetResponse;

public interface IPlanetUseCase {
	PlanetResponse addPlanet(PlanetRequest request);

	Page<PlanetResponse> listPlanet(Pageable pageable);

	PlanetResponse searchPlanetByName(String name);

	PlanetResponse searchPlanetById(String id);

	void removePlanetById(String id);
}
