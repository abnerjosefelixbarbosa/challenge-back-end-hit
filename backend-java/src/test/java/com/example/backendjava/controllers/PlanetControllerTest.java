package com.example.backendjava.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Disabled;
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
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles
@AutoConfigureMockMvc
public class PlanetControllerTest {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	@Disabled
	public void shouldAddPlanetAndReturnStatus201() throws Exception {
		PlanetRequest request = new PlanetRequest();
		HttpHeaders httpHeaders = new HttpHeaders();
		
		String object = mapper.writeValueAsString(request);
	
		mvc.perform(post("/api/async-token/authenticate")
				.contentType(MediaType.APPLICATION_JSON)
				.headers(httpHeaders)
				.content(object))
		.andExpect(MockMvcResultMatchers.status().isCreated())
		.andDo(print());
	}
}