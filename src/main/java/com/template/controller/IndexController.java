package com.template.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.template.model.dto.PersonDto;
import com.template.model.entity.Person;
import com.template.service.PersonService;

@Controller
public class IndexController {
	private final Logger _logger = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index(){
		return "hello world!";
	}
	
	@RequestMapping("/test")
	public String test(Model model){
		PersonDto person = new PersonDto("admin",110);
		model.addAttribute("singlePerson", person);
		List<PersonDto> people = new ArrayList<PersonDto>();
		PersonDto person1 = new PersonDto("zjx",27);
		PersonDto person2 = new PersonDto("zhangsan",1);
		PersonDto person3 = new PersonDto("lisi",2);
		people.add(person1);
		people.add(person2);
		people.add(person3);
		model.addAttribute("people", people);
		return "index";
	}
	
	@RequestMapping("/testAdd")
	public String testAdd(Model model){
		PersonDto person = new PersonDto();
		model.addAttribute("people", person);
		return "add";
	}
	
	@RequestMapping("/testSave")
	public String testSave(Model model,@Valid @ModelAttribute("people") PersonDto people,BindingResult result){
		if(result.hasErrors()){
			_logger.info("field valid failed");
			model.addAttribute("people", people);
			return "add";
		}else{
			Person person = personService.save(people);
			model.addAttribute("person", people);
			return "view";
		}
	}
}
