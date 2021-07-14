package com.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.dao.UserDao;
import com.register.entity.Distributer;
import com.register.entity.Retailer;
import com.register.repository.DistributorDataRepositroy;
import com.register.repository.RetailerDataRepository;
import com.register.service.RegisterService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController {
   
    @Autowired
    private UserDao userDao;
   
    @Autowired
    private RegisterService service;
   
    @Autowired
    private RetailerDataRepository retailerRepository;
   
    @Autowired
    DistributorDataRepositroy distributerRepository;
   
     @PostMapping({"/Retailer"})
        public Retailer registerNewUser(@RequestBody Retailer retailer) {
 
    	 	//Find did on the basis of city
    	 	String did = distributerRepository.findDidByCity(retailer.getCity());
    	 	retailer.setDid(did);
            return service.registerNewUser(retailer);
        }
     @PostMapping({"/Distributor"})
        public Distributer registerDistributor(@RequestBody Distributer distributor) {    
            return service.registerDistributor(distributor);
        }
    
    //Get all Retailers list API
     @RequestMapping({"/Retailer"})   //***
        public Iterable<Retailer> getAllUsers(){
            return retailerRepository.findAll();
        }
   
     @RequestMapping("/Distributor/count")
     public long countDistributer() {
         return distributerRepository.count();
     }
     @RequestMapping("/Retailer/count")
     public long countRetailer() {
         return retailerRepository.count();
     }
   
    //Get all distributer data API
     @RequestMapping({"/Distributor"})   //***
        public List<Distributer> getAll(){
            return distributerRepository.findAll();
        }
       
       
}