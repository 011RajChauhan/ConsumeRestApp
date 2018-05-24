package com.consume.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.consume.models.Person;

@Controller
@RequestMapping("/resteater")
public class RestConsumingController {
	
	@RequestMapping(value = "/personDetails", method = RequestMethod.GET)
	public String getForObjectDemoWithJson(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		Person person  = restTemplate.getForObject("http://localhost:8081/RestCRUDWithoutDao/rest/fetchjson/{id}", Person.class,1);
		System.out.println(person);
		return "temp";
	}
	
	@RequestMapping(value = "/exchangeGetREsponseEntity", method = RequestMethod.GET)
	public String getResponseEntityViaExchange() {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8081/RestCRUDWithoutDao/rest/exchange/{id}";
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("Hello World!", headers);
		ResponseEntity<Person> personEntity = restTemplate.exchange(uri,HttpMethod.GET,entity, Person.class,1);
		System.out.println(personEntity.getBody());
		return "temp";
	}
}
