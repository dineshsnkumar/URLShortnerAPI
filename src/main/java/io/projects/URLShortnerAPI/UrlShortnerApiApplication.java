package io.projects.URLShortnerAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class UrlShortnerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortnerApiApplication.class, args);
	}

}
