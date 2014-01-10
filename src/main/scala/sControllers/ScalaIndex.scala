package sControllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod._
import org.springframework.web.bind.annotation.{PathVariable, RequestMapping}
import org.springframework.beans.factory.annotation.Autowired
import org.hibernate.SessionFactory
import sModels.Customer
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.transaction.annotation.Transactional
import javax.persistence.Entity
import sModels.MongoScalaCustomer
import dao.ScalaMongoCustomerRepository
import org.springframework.data.mongodb.core.MongoTemplate

@Controller
@RequestMapping(Array("/scala"))
class ScalaIndex {
  
	@Autowired var mongoTemplate: MongoTemplate = null
	
	@RequestMapping(value=Array(""),method=Array(GET))
	def showHello = { 	  	  
	  "scala"
	}
	
	@RequestMapping(value=Array("/mongo"), method=Array(GET))
	def mongo = {
	  val c1: MongoScalaCustomer = new MongoScalaCustomer
	  c1.firstname = "Matt"
	  c1.lastname = "Silbernagel"
	  
	  val c2: MongoScalaCustomer = new MongoScalaCustomer
	  c2.firstname = "Steve"
	  c2.lastname = "Crump"
	  
	  mongoTemplate.save(c1);
	  mongoTemplate.save(c2);
	  
	  "mongo";
	}
	
}