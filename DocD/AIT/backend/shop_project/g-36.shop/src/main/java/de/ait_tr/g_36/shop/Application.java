package de.ait_tr.g_36.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "de.ait_tr.g_36")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
