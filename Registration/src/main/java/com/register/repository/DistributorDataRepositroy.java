package com.register.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.register.entity.Distributer;

@Repository
public interface DistributorDataRepositroy  extends JpaRepository<Distributer, String> {

	@Query(value="select did from distributer where city = :city",nativeQuery = true)
	public String findDidByCity(String city);
	
	@Query(value="select * from distributer where user_name = :userName",nativeQuery = true)
	public Distributer findDidByUserName(String userName);
	
}
 



