package com.unpredictableXpractice.StoreX;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreXApplication {
	public static void main(String[] args)
	{
		Dotenv dotenv = Dotenv.configure().ignoreIfMalformed().load();
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

		SpringApplication.run(StoreXApplication.class, args);
		System.out.println("StoreX Application Started");
	}

}
