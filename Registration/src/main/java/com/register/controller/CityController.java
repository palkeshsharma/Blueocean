package com.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.entity.City;
import com.register.exception.ResourceNotFoundException;
import com.register.repository.CityRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/city")
public class CityController {

	@Autowired
	private CityRepository cityRepository;
	
	@GetMapping("/distributer")
	public List<City> getCity() {
		List<City> c = cityRepository.getAllDCities();
		return c;
	}
	
	@GetMapping("/retailer")
	public List<City> getRCity() {
		List<City> c = cityRepository.getAllRCities();
		return c;
	}
	
	@GetMapping("/distributer/change/{city}")
	public City changeStatus(@PathVariable String city) {
		City c = cityRepository.findById(city).orElseThrow(()->new ResourceNotFoundException("No such city exist"));
		c.setStatus(false);
		cityRepository.save(c);
		return c;
	}
}
