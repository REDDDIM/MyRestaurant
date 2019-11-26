package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = {"controller", "services.impl", "services", "config"})
@EntityScan(basePackages = {"entities"})
@EnableJpaRepositories(basePackages = {"dao.repository"})
public class MyRestaurantApp {
    public static void main(String[] args) {
        SpringApplication.run(MyRestaurantApp.class, args);
    }
}
