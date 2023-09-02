Config server example
---------------------
1)  create a server project with all the dependencies 
    		<dependency>
    			<groupId>org.springframework.cloud</groupId>
    			<artifactId>spring-cloud-config-server</artifactId>
    		</dependency>
2)   in the application.properties file add the configuration 
        server.port = 8888
        spring.cloud.config.server.git.default-label=master
        spring.cloud.config.server.git.uri = C:\\users\\krish\\abcdir
3)    add the main class with the annotation 
      @SpringBootApplication
      @EnableConfigServer
      public class ConfigServerApplication {
      	public static void main(String[] args) {
      		SpringApplication.run(ConfigServerApplication.class, args);
      	}
      }
config client example
---------------------
1)  create a client project with all the dependencies       
    		<dependency>
    			<groupId>org.springframework.cloud</groupId>
    			<artifactId>spring-cloud-starter-config</artifactId>
    		</dependency>
2)    in the application.properties file add the configuration
          spring.application.name=first-service
          spring.config.import=optional:configserver:http://localhost:8888/     
3)    add the main class with the annotation 
      @SpringBootApplication
      public class Service1Application {
      	public static void main(String[] args) {
      		SpringApplication.run(Service1Application.class, args);
      	}
      }
