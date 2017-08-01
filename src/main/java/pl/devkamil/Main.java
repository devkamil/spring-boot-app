package pl.devkamil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


/**
 * This class is a main class of application which contains Spring Boot "run" method
 */
@SpringBootApplication
public class Main extends SpringBootServletInitializer {

	
	/**
	 * Configure Spring Boot Application
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Main.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(Main.class, args);
	}
}
