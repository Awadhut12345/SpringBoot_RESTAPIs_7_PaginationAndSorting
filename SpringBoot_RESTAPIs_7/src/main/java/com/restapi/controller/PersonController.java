package com.restapi.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entity.Person;
import com.restapi.service.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
	
	 private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonService personService;

	@Autowired
	public PersonController(PersonService  personService) {
		this.personService=personService;
	}
	
    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable Integer id) {
    	logger.info("Find a person by id: {}", id);

        return personService.getPersonById(id);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
    	logger.info("Creating a new person: {}", person.getName());
        return personService.createPerson(person);
    }

    @PutMapping("/{id}")
    public Optional<Person> updatePerson(@PathVariable Integer id, @RequestBody Person personDetails) {
    	logger.info("Update a existing person: {}", personDetails.getName());
        return personService.updatePerson(id, personDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Integer id) {
    	logger.info("Delete a person : {}", id);
        personService.deletePerson(id);
    }
    
    @GetMapping("/page")
    public Page<Person> getPersonsPage(@RequestParam int page, int size) {
    	return personService.getPersonPage(page, size);
    }
    
    @GetMapping("/page/sorted")
    public Page<Person> getPersonsPageSorted(@RequestParam int page, @RequestParam int size, @RequestParam String sortBy) {
		return personService.getPersonsPageSorted(page, size, sortBy);
    	
    }
}
