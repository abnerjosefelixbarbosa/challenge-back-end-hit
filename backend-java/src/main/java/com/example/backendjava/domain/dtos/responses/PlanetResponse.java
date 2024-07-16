package com.example.backendjava.domain.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanetResponse {
	private String id;
	private String name;
	private String climate;
	private String terrain;
}
