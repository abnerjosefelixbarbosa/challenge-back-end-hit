package com.example.backendjava.domain.dtos.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanetSwapiGetResponse {
	private Long count;
	private String next;
	private String previous;
	private List<PlanetSwapiResponse> results;
}
