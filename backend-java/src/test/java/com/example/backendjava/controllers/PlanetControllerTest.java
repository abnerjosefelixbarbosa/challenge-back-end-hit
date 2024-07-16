package com.example.backendjava.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.backendjava.domain.dtos.requests.PlanetRequest;
import com.example.backendjava.infra.entities.Planet;
import com.example.backendjava.infra.repositories.IPlanetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class PlanetControllerTest {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private IPlanetRepository planetRepository;
	
	@BeforeEach
	public void setup() {
		planetRepository.deleteAll();
	}

	@AfterEach
	public void tearDown() {
		planetRepository.deleteAll();
	}
	
	@Test
	public void shouldAddPlanetAndReturnStatus201() throws Exception {
		PlanetRequest request = new PlanetRequest("Tatooine", "arid", "desert");
		HttpHeaders httpHeaders = new HttpHeaders();
		
		String object = mapper.writeValueAsString(request);
	
		mvc.perform(post("/api/planets/add-planet")
				.contentType(MediaType.APPLICATION_JSON)
				.headers(httpHeaders)
				.content(object))
		.andExpect(MockMvcResultMatchers.status().isCreated())
		.andDo(print());
	}
	
	@Test
	public void shoulListPlanetsAndReturnStatus200() throws Exception {
		Planet planet1 = new Planet(null, "Tatooine", "arid", "desert", 5L);
		Planet planet2 = new Planet(null, "Alderaan", "temperate", "grasslands, mountains", 2L);
		Planet planet3 = new Planet(null, "Yavin IV", "temperate, tropical", "jungle, rainforests", 1L);
		
		planetRepository.save(planet1);
		planetRepository.save(planet2);
		planetRepository.save(planet3);
		
		HttpHeaders httpHeaders = new HttpHeaders();
	
		mvc.perform(get("/api/planets/list-planets")
				.headers(httpHeaders))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
	}
	
	@Test
	public void searchPlanetByNameAndReturnStatus200() throws Exception {
		Planet planet = new Planet(null, "Tatooine", "arid", "desert", 5L);
		
		planet = planetRepository.save(planet);
		
		HttpHeaders httpHeaders = new HttpHeaders();
	
		mvc.perform(get("/api/planets/search-planet-by-name?name=" + planet.getName())
				.headers(httpHeaders))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
	}
	
	@Test
	public void searchPlanetByIdAndReturnStatus200() throws Exception {
		Planet planet = new Planet(null, "Tatooine", "arid", "desert", 5L);
		
		planet =  planetRepository.save(planet);
		
		HttpHeaders httpHeaders = new HttpHeaders();
	
		mvc.perform(get("/api/planets/search-planet-by-id?id=" + planet.getId())
				.headers(httpHeaders))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
	}
	
	@Test
	public void removePlanetByIdAndReturnStatus204() throws Exception {
		Planet planet = new Planet(null, "Tatooine", "arid", "desert", 5L);
		
		planet =  planetRepository.save(planet);
		
		HttpHeaders httpHeaders = new HttpHeaders();
	
		mvc.perform(delete("/api/planets/remove-planet-by-id?id=" + planet.getId())
				.headers(httpHeaders))
		.andExpect(MockMvcResultMatchers.status().isNoContent())
		.andDo(print());
	}
}