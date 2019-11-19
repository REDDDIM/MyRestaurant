package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"login", "registration", "admin", "client", "config"})
/*@EnableJpaRepositories(basePackages = {"dao"})*/
@EntityScan(basePackages = {"entities"})
public class MyRestaurantApp {
    public static void main(String[] args) {
        SpringApplication.run(MyRestaurantApp.class, args);
    }
}
