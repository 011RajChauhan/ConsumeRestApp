package com.consume.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.consume.models.Country;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		String message = "this app consumes REST services, click below links to get country serives data.";
		RestTemplate rest = new RestTemplate();
		//learn how to handle exception if this rest call sends null
		Country [] countryItems = rest.getForObject("http://localhost:8081/RestCRUDWithoutDao/country/allCountries", Country[].class);
		model.addAttribute("countryList",countryItems);
		model.addAttribute("message", message);
		return "home";
	}
	
	@RequestMapping(value = "/getCountries/{countryId}", method = RequestMethod.GET)
	public String getCountries(Model model, @PathVariable Integer countryId) {
		RestTemplate rest = new RestTemplate();
		Country country = rest.getForObject("http://localhost:8081/RestCRUDWithoutDao/country/getCountry/{countryId}", Country.class,countryId);
	
		System.out.println(country.getId());
		System.out.println(country.getCountryName());
		//System.out.println(country.getPopulation());
		
		model.addAttribute("country",country);
		return "countryDetails";
	}
}
