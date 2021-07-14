package com.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.register.entity.Distributer;
import com.register.entity.Retailer;
import com.register.repository.DistributorDataRepositroy;
import com.register.repository.RetailerDataRepository;

@Service
public class RegisterService {
    @Autowired
    private RetailerDataRepository retailerRepository;
    
    @Autowired
    DistributorDataRepositroy distributerRepository;
    
        @Autowired
        private PasswordEncoder passwordEncoder;
        
        public Retailer registerNewUser(Retailer retailer) {   
            
             long  count=retailerRepository.count();
             retailer.setRid("R"+(++count));
                //"USer"
             retailer.setUserPassword(getEncodedPassword(retailer.getUserPassword()));
            return retailerRepository.save(retailer);
        }

 

        
        public Distributer registerDistributor(Distributer distributor) {         
               //Distributor
           long  count=distributerRepository.count();
           distributor.setDid("D"+(++count));
           distributor.setUserPassword(getEncodedPassword(distributor.getUserPassword()));
            return distributerRepository.save(distributor);
        }
        
        public String getEncodedPassword(String password) {
            return passwordEncoder.encode(password);
        }

 

}
 



