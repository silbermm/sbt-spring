package controllers;

import models.MongoCustomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sModels.MongoScalaCustomer;
import dao.MongoCustomerRepository;

@Controller
@RequestMapping(value="/")
public class IndexController {

	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("test", "hello");
		return "index";
	}
		
	@RequestMapping(value="/mongo", method=RequestMethod.GET)
	public String mongo(Model model) {
		MongoCustomer c1 = new MongoCustomer("Matt", "Silbernagel");
		MongoCustomer c2 = new MongoCustomer("Gurinder", "Ahluwalia");
		
		MongoScalaCustomer c3 = new MongoScalaCustomer();
		c3.firstname_$eq("Steve");
		c3.lastname_$eq("Crump");
		
		
		mongoRepo.save(c1);
		mongoRepo.save(c2);
		
		return "mongo";
	}
	
	
	
	@Autowired MongoCustomerRepository mongoRepo;
}
