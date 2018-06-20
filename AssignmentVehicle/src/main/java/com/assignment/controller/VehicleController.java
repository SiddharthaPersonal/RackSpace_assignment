package com.assignment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assignment.model.Vehicle;
import com.assignment.service.VehicleService;

@Controller
public class VehicleController {

	private static final Logger logger = Logger.getLogger(VehicleController.class);

	public VehicleController() {
		System.out.println("VehicleController()");
	}

	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(value = "/")
	public ModelAndView listVehicle(ModelAndView model) throws IOException {
		List<Vehicle> listVehicle = vehicleService.findAll();
		model.addObject("listVehicle", listVehicle);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/newVehicle", method = RequestMethod.GET)
	public ModelAndView newVehicle(ModelAndView model, HttpServletRequest request) {
		Vehicle Vehicle = new Vehicle();
		model.addObject("Vehicle", Vehicle);
		model.setViewName("VehicleForm");
		return model;
	}

	@RequestMapping(value = "/saveVehicle", method = RequestMethod.POST)
	public ModelAndView saveVehicle(@ModelAttribute Vehicle vehicle) {
		if (vehicle.getId() == 0) { // if Vehicle id is 0 then creating the
			// Vehicle other updating the Vehicle
			vehicleService.add(vehicle);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteVehicle", method = RequestMethod.GET)
	public ModelAndView deleteVehicle(HttpServletRequest request) {
		Long VehicleId = Long.parseLong(request.getParameter("id"));
		vehicleService.delete(VehicleId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/findVehicle", method = RequestMethod.GET)
	public ModelAndView findVehicle(HttpServletRequest request) {
		long vehicleId = Long.parseLong(request.getParameter("id"));
		Vehicle vehicle = vehicleService.findOne(vehicleId);
		ModelAndView model = new ModelAndView("VehicleForm");
		model.addObject("Vehicle", vehicle);

		return model;
	}

}