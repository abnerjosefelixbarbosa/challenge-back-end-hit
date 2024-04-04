package com.example.backendjava.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Planet 
{
	private String id;
	private String name;
	private String climate;
	private String terrain;
}
