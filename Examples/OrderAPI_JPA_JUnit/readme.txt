Spring Microservice example
---------------------------
1)	create a spring project 

2)	add the dependencies for the project 
		a)	spring web 
		b)	spring data jpa
		c)	h2
		d)	testcontainers
		e)	spring validator 
		
3)	add all the layers

4)	add the db details in the application.json 

5)  db details

	## H2 db configuration
	spring.datasource.url=jdbc:h2:mem:testdb
	spring.datasource.driverClassName=org.h2.Driver
	spring.datasource.username=sa
	spring.datasource.password=
	spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
	
	## MySQL db configuration
	spring.datasource.url=jdbc:mysql://localhost:3306/practice
	spring.datasource.username=root
	spring.datasource.password=root
	spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL57Dialect
    
