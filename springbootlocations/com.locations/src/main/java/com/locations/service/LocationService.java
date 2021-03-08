package com.locations.service;

import java.util.List;



import com.locations.entities.Locations;

public interface LocationService {

	Locations saveLocation(Locations location);

	Locations upadteLocation(Locations location);

	void deleteLocation(Locations location);

	Locations getLocationById(int id);

	List<Locations> getAllLocations();
	

}
