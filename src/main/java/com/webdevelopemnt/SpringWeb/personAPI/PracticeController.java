package com.webdevelopemnt.SpringWeb.personAPI;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PracticeController {
	
	@RequestMapping("/persons")
	public List<Person> getPersons(){
		List<Person> list = new ArrayList<>();
		list.add(new Person("Vikram",24));
		list.add(new Person("Pavan Kalyan",27));
		return list;
	}
	
	

}
