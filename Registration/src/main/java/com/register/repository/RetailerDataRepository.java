package com.register.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.register.entity.Retailer;

@Repository
public interface RetailerDataRepository extends JpaRepository<Retailer, String>{

	@Query(value="select * from retailer where did = :did",nativeQuery = true)
	public List<Retailer> findByDId(String did);
	
	@Query(value="select * from retailer where user_name = :userName",nativeQuery = true)
	public Retailer findRidByUserName(String userName);
	
}
 


