package com.assignment.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.dao.VehicleRepository;
import com.assignment.model.Vehicle;

/** 
 * Service layer.
 */
@Component
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Transactional
	public void add(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
	
	@Transactional
	public void update(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
	
	@Transactional(readOnly=true)
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	@Transactional
	public void addAll(Collection<Vehicle> products) {
		for (Vehicle product : products) {
			vehicleRepository.save(product);
		}
	}

	@Transactional(readOnly=true)
	public List<Vehicle> findByNameIs(String name) {
		return vehicleRepository.findByNameIs(name);
	}
	
	@Transactional(readOnly=true)
	public List<Vehicle> findByNameContainingIgnoreCase(String searchString) {
		return vehicleRepository.findByNameContainingIgnoreCase(searchString);
	}
	
	@Transactional(readOnly=true)
	public void delete(long vehicleId) {
		vehicleRepository.delete(vehicleId);
	}

	public Vehicle findOne(long vehicleId) {
		// TODO Auto-generated method stub
		return vehicleRepository.findOne(vehicleId);
		return null;
	}
}
