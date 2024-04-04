package com.example.backendjava.infra.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backendjava.infra.entities.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, String> 
{
	Optional<Planet> findByName(String name);
	boolean existsByName(String name);
}