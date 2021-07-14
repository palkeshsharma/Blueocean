package com.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.entity.Retailer;
import com.register.exception.ResourceNotFoundException;
import com.register.repository.RetailerDataRepository;

@RestController
@RequestMapping("api/u2")
@CrossOrigin(origins = "http://localhost:4200")
public class RetailerController {

	@Autowired
	private RetailerDataRepository retailerRepository;
	
	//Get all Retailers list API
	@GetMapping("/retailer")
	public List<Retailer> getRetailer(){
		return retailerRepository.findAll();
	}
	
	//Get total retailer API
	@GetMapping("retailer/count")
	public long countUser() {
		return retailerRepository.count();
	}
	
	//Get retailer info from Rid API
	@GetMapping("/retailer/info/{rid}")
	public Retailer getRetailerByRid(@PathVariable String rid) {
		return retailerRepository.findById(rid).orElseThrow(()-> new ResourceNotFoundException("No such entity exist"));
	}
	
	//Get retailer by Distributer id API
	@GetMapping("/retailer/{did}")
	public List<Retailer> getRetailer(@PathVariable String did) {
		 return retailerRepository.findByDId(did);
	}
	
	//Get did on the basis of userName
	@GetMapping("retailer/find/{userName}")
	public Retailer getRetailerId(@PathVariable String userName) {
		
		return retailerRepository.findRidByUserName(userName);
	}
}
