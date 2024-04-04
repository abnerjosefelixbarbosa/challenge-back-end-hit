package com.example.backendjava.domain.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.backendjava.adapters.PlanetAdapeter;
import com.example.backendjava.domain.dtos.requests.PlanetRequest;
import com.example.backendjava.domain.dtos.responses.PlanetResponse;

@Service
public class PlanetUseCase implements PlanetAdapeter {

	public PlanetResponse addPlanet(PlanetRequest request) {
		return null;
	}

	public Page<PlanetResponse> listPlanet(Pageable pageable) {
		return null;
	}

	public PlanetResponse searchPlanetByName(String name) {
		return null;
	}

	public PlanetResponse searchPlanetById(String id) {
		return null;
	}

	public void removePlanetById(String id) {
	}
}
