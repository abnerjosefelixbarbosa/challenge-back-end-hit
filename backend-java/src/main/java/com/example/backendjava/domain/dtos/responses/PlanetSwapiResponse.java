package com.example.backendjava.domain.dtos.responses;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanetSwapiResponse<T> {
	private String name;
	@JsonProperty("rotation_period")
	private Long rotation_period;
	@JsonProperty("orbital_period")
	private Long orbital_period;
	private Long diameter;
	private String climate;
	private String gravity;
	private String terrain;
	@JsonProperty("surface_water")
	private Long surface_water;
	private Long population;
	private List<String> residents;
	private List<String> films;
	private Date created;
	private Date edited;
	private String url;
	
	public PlanetSwapiResponse(Object val) {
		this.name = val.getClass().getName();
	}
}