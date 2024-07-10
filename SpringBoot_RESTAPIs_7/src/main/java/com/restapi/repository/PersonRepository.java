package com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
