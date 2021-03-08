package com.locations.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.locations.entities.Locations;
import com.locations.repo.LocationRepository;
import com.locations.service.LocationService;
import com.locations.util.EmailUtil;
import com.locations.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	LocationService service;
	@Autowired
	EmailUtil emailUtil;

	@Autowired
	LocationRepository repository;
	
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	ServletContext sc;

	@RequestMapping("/create")
	public String create() {
		return "createLocation";
	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("locations") Locations location, ModelMap modelMap) {
		Locations locationSaved = service.saveLocation(location);
		String msg = "Location saved with id: " + locationSaved.getId();
		modelMap.addAttribute("message", msg);
		emailUtil.sendEmail("johnqatwork21@gmail.com", "Location Saved", "Location Saved Successfully");
		return "createLocation";

	}

	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Locations> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		emailUtil.sendEmail("johnqatwork21@gmail.com", "This is from Display Page", "Trying To send email");
		return "displayLocations";
	}

	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Locations locationById = service.getLocationById(id);
//		Locations location =new Locations(); also can me used
//		location.setId(id);
		service.deleteLocation(locationById);
		List<Locations> allLocations = service.getAllLocations();
		modelMap.addAttribute("locations", allLocations);
		emailUtil.sendEmail("johnqatwork21@gmail.com", "Location Deleted", "Location Deleted");
		return "displayLocations";
	}

	@RequestMapping("/test")
	public String test() {
		return "test";
	}

	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Locations updateLocationById = service.getLocationById(id);
		modelMap.addAttribute("locations", updateLocationById);

		return "editLocation";

	}

	@RequestMapping("/editLocation")
	public String editLocation(@ModelAttribute("locations") Locations location, ModelMap modelMap) {

		service.upadteLocation(location);

		List<Locations> allLocations = service.getAllLocations();
		modelMap.addAttribute("locations", allLocations);
		emailUtil.sendEmail("johnqatwork21@gmail.com", "Location Updated", "Location Updated in DB");
		return "displayLocations";
	}

	@RequestMapping("/sendEmail")
	public String displayLocations1(ModelMap modelMap) {
		List<Locations> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		emailUtil.sendEmail("johnqatwork21@gmail.com", "This is from Display Page", "Trying To send email");
		return "sendEmail";
	}

//	@RequestMapping("/generateReport")
//	public String generateReport() {
//		String path = sc.getRealPath("/");
//
//		List<Object[]> data = repository.findTypeAndTypeCount();
//		reportUtil.generatePieChart(path, data);
//		return "report";
//
//	}

}
