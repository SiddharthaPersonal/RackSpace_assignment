package com.assignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	//public List<Vehicle> findAll();


	public List<Vehicle> findByNameContainingIgnoreCase(String searchString);
	
	
	@Query("select p from Vehicle p where p.name = :name")
    public List<Vehicle> findByNameIs(@Param("name") String name);
    
}
