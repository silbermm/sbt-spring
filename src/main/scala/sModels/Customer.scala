package sModels

import javax.persistence.{GeneratedValue, Id, Entity}
import reflect.BeanProperty
import javax.persistence.Column
 
@Entity
class Customer() {
  
	@Id @GeneratedValue
	var id: Long = 0
	
	@BeanProperty
	var name: String = null 
}