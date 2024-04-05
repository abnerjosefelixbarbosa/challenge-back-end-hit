package com.example.backendjava.domain.dtos.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanetSwapiResponse {
	private String name;
	@JsonProperty("rotation_period")
	private Long rotationPeriod;
	@JsonProperty("orbital_period")
	private Long orbitalPeriod;
	private Long diameter;
	private String climate;
	private String gravity;
	private String terrain;
	@JsonProperty("surface_water")
	private String surfaceWater;
	private String population;
	private List<String> residents;
	private List<String> films;
	private String created;
	private String edited;
	private String url;
}