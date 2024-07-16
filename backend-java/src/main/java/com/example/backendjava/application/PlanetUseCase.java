package com.example.backendjava.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.example.backendjava.adapters.IPlanetGateWay;
import com.example.backendjava.domain.dtos.requests.PlanetRequest;
import com.example.backendjava.domain.dtos.responses.PlanetResponse;
import com.example.backendjava.domain.usecase.IPlanetUseCase;

@Component
public class PlanetUseCase implements IPlanetUseCase {
	@Autowired
	private IPlanetGateWay planetGateWay;

	public PlanetResponse addPlanet(PlanetRequest request) {
		return planetGateWay.addPlanet(request);
	}

	public Page<PlanetResponse> listPlanet(Pageable pageable) {
		return planetGateWay.listPlanet(pageable);
	}
	
	public PlanetResponse searchPlanetByName(String name) {
		return planetGateWay.searchPlanetByName(name);
	}

	public PlanetResponse searchPlanetById(String id) {
		return planetGateWay.searchPlanetById(id);
	}

	public void removePlanetById(String id) {
		planetGateWay.removePlanetById(id);
	}

}
