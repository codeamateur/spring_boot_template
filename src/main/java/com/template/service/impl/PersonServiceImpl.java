package com.template.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.template.model.dto.PersonDto;
import com.template.model.entity.Person;
import com.template.repository.PersonRepository;
import com.template.service.PersonService;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person save(PersonDto dto) {
//		Person person = BeanMapper.map(dto, Person.class);
		Person person = new Person();
		person.setName(dto.getName());
		person.setAge(dto.getAge());
		return personRepository.save(person);
	}

}
