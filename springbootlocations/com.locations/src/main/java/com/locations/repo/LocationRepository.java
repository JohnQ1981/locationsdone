package com.locations.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.locations.entities.Locations;

public interface LocationRepository extends JpaRepository<Locations, Integer> {
	
//	@Query("SELECT type,count(type)FROM locations  group by type")
//	public List<Object[]> findTypeAndTypeCount();
	

}
