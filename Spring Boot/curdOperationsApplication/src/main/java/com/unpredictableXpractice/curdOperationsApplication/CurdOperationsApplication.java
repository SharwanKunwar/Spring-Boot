package com.unpredictableXpractice.curdOperationsApplication;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurdOperationsApplication {
	public static void main(String[] args)
	{
		Dotenv dotenv = Dotenv.configure().load();
		dotenv.entries().forEach((entry) -> System.out.println(entry.getKey() + ": " + entry.getValue()));

		SpringApplication.run(CurdOperationsApplication.class, args);
		System.out.println("hell");
	}


}
