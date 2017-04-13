package com.template.service;

import com.template.model.dto.PersonDto;
import com.template.model.entity.Person;

public interface PersonService {
	
	public Person save(PersonDto dto);

}
