package config;


import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mongodb.Mongo;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;


@Configuration
@EnableMongoRepositories({"dao", "sDao"})
@EnableWebMvc
@ComponentScan(basePackages = { "service", "dao", "models", "config", "dao","sModels" })
public class AppContext {
	
	private static final Logger log = LoggerFactory.getLogger(AppContext.class);

	@Bean
	public Config config() {
		return ConfigFactory.load().withFallback(
				ConfigFactory.systemProperties());
	}
	
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder sf = new LocalSessionFactoryBuilder(dataConfig.dataSource()).scanPackages("sModels");		
		return sf.buildSessionFactory();
	}
		
	@Bean(name = "transactionManager")
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager t = new HibernateTransactionManager();
		t.setSessionFactory(sessionFactory());
		return t;
	}
	
	@Bean
	public MongoFactoryBean mongo() {
        MongoFactoryBean mongo = new MongoFactoryBean();
        mongo.setHost("localhost");        
        return mongo;
	}
	
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {	    
	    return new SimpleMongoDbFactory(new Mongo(), "scalaSpring");
	 }

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		 return new MongoTemplate(mongoDbFactory());
	 }
	
	@Autowired DataConfig dataConfig;

}
