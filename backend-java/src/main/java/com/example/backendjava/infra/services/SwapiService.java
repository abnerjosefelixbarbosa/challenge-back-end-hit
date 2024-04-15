package com.example.backendjava.infra.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.backendjava.domain.dtos.requests.PlanetRequest;
import com.example.backendjava.domain.dtos.responses.PlanetSwapiGetResponse;
import com.example.backendjava.domain.dtos.responses.PlanetSwapiResponse;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SwapiService extends Thread {
	public Long getNumberAppearancesFilms(PlanetRequest request) {
		final String URL = "https://swapi.dev/api/";
		RestTemplate template = new RestTemplate();
		PlanetSwapiGetResponse responses = template.getForObject(URL + "planets/", PlanetSwapiGetResponse.class);
		Long numberAppearances = null;
		
		try {
			PlanetSwapiResponse response = responses.getResults().stream()
					.filter((val) -> val.getName().equals(request.getName())
							&& val.getClimate().equals(request.getClimate())
							&& val.getTerrain().equals(request.getTerrain()))
					.findFirst().orElseThrow(() -> new EntityNotFoundException("planet not found"));
			
			numberAppearances = Long.valueOf(response.getFilms().size());
			
			sleep(3000);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		return numberAppearances;
	}
}