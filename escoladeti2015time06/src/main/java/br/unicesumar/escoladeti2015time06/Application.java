package br.unicesumar.escoladeti2015time06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.unicesumar.escoladeti2015time06")
public class Application {
    
    public static void main(String[] args) {
        
        SpringApplication.run(Application.class, args);
       
    }
    
    
    
}