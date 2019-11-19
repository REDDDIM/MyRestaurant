package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"entities"})
@EnableJpaRepositories(basePackages = {"dao.repository"})
public class MyRestaurantApp {
    public static void main(String[] args) {
        SpringApplication.run(MyRestaurantApp.class, args);
    }
}
