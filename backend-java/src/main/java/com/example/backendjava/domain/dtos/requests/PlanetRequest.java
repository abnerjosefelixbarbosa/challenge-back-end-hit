package com.example.backendjava.domain.dtos.requests;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanetRequest
{
	@NotNull
	@NotEmpty
	@Length(max = 50)
	private String name;
	@NotNull
	@NotEmpty
	@Length(max = 30)
	private String climate;
	@NotNull
	@NotEmpty
	@Length(max = 30)
	private String terrain;
}
