package com.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.template.model.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
