package sModels

import org.springframework.data.annotation.Id


class MongoScalaCustomer {
  
  @Id var id: String = null
  var firstname: String = null
  var lastname: String = null

}