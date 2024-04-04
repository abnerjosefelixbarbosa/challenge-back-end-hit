package com.example.backendjava.infra.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.backendjava.domain.dtos.responses.PlanetSwapiGetResponse;
import com.example.backendjava.domain.dtos.responses.PlanetSwapiResponse;

@Service
public class SwapiService {
	private final String URL = "https://swapi.dev/api/"; 
	//@Autowired	
	//private ObjectMapper objectMapper;
	
	public PlanetSwapiGetResponse getResponses() 
	{
		try 
		{
			RestTemplate template = new RestTemplate();
			var responses = template
					.getForObject(URL + "planets/", PlanetSwapiGetResponse.class);
			
			var list = responses.getResults()
					.stream()
					.map(PlanetSwapiResponse::new)
					.collect(Collectors.toList());
			
			/*
			Collection<PlanetSwapiResponse> list = new ArrayList<PlanetSwapiResponse>();
			
			responses.getResults().forEach((val) -> {
				try 
				{
					var a = objectMapper
					.readValue(val.toString(), PlanetSwapiResponse.class);
					list.add(a);
				} catch (Exception e) 
				{
					throw new RuntimeException(e.getMessage());
				} 
			});
			*/
			
			System.out.println(list);
		} catch (Exception e) 
		{
			throw new RuntimeException(e.getMessage());
		} 
		return null;
	}
}