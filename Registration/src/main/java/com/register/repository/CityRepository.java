package com.register.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.register.entity.City;

public interface CityRepository extends JpaRepository<City, String>{

	@Query(value = "select * from city where status=TRUE",nativeQuery = true)
	public List<City> getAllDCities();
	
	@Query(value = "select * from city where status=FALSE",nativeQuery = true)
	public List<City> getAllRCities();
	
}
