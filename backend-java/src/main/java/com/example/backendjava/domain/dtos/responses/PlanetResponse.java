package com.example.backendjava.domain.dtos.responses;

import com.example.backendjava.infra.entities.Planet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanetResponse 
{
	private String id;
	private String name;
	private String climate;
	private String terrain;
	
	public PlanetResponse(Planet planet) 
	{
		this.id = planet.getId();
		this.name = planet.getName();
		this.climate = planet.getClimate();
		this.terrain = planet.getTerrain();
	}
}
