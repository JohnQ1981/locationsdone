package com.locations.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locations.entities.Locations;
import com.locations.repo.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRestController {

	@Autowired
	LocationRepository locationRepository;

	@GetMapping
	public List<Locations> getLocations() {

		return locationRepository.findAll();

	}

	@PostMapping
	public Locations createLocation(@RequestBody Locations location) {

		return locationRepository.save(location);

	}
	
	
	@PutMapping
	public Locations updateLocation(@RequestBody Locations location) {
		return locationRepository.save(location);
	}

	@DeleteMapping("/{id}")
	public void deleteLocationById(@PathVariable("id") int id) {
		locationRepository.deleteById(id);
		
	}
	
	@GetMapping("/{id}")
	public Optional<Locations> getLocationByID(@PathVariable("id") int id) {
		
		return locationRepository.findById(id);
	}
	
}
