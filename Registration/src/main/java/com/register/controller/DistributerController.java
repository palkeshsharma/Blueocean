package com.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.entity.Distributer;
import com.register.exception.ResourceNotFoundException;
import com.register.repository.DistributorDataRepositroy;

@RestController
@RequestMapping("/api/u1")
@CrossOrigin(origins = "http://localhost:4200")
public class DistributerController {

	@Autowired
	DistributorDataRepositroy distributerRepository;
	
	//Get all distributer data API
	@GetMapping("/distributer")
	public List<com.register.entity.Distributer> getDistributer(){
		return distributerRepository.findAll();
	}

	//Get total distributer API
	@GetMapping("distributer/count")
	public long countUser() {
		return distributerRepository.count();
	}
	
	@GetMapping("distributer/{did}")
	public Distributer getDistributerInfo(@PathVariable String did) {
		 Distributer info = distributerRepository.findById(did).orElseThrow(()-> new ResourceNotFoundException("No such id exist"));
		 return info;
	}
	
	//Get did on the basis of userName
	@GetMapping("distributer/find/{userName}")
	public Distributer getDistributerId(@PathVariable String userName) {
		
		Distributer did = distributerRepository.findDidByUserName(userName);
		return did;
	}
	
}

