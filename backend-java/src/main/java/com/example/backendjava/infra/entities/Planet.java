package com.example.backendjava.infra.entities;

import java.io.Serializable;

import com.example.backendjava.domain.dtos.requests.PlanetRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "planet_tb")
public class Planet implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(nullable = false, unique = true)
	private String name;
	@Column(nullable = false)
	private String climate;
	@Column(nullable = false)
	private String terrain;
	@Column(nullable = false)
	private Long apparition;
	
	public Planet(PlanetRequest request) 
	{
		this.name = request.getName();
		this.climate = request.getClimate();
		this.terrain = request.getTerrain();
	}
}