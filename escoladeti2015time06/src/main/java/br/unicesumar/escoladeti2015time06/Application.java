package br.unicesumar.escoladeti2015time06;

import br.unicesumar.escoladeti2015time06.ItemsDeAcesso.ItemDeAcessoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        carregarItensPadrao();
        SpringApplication.run(Application.class, args);
        
    }

    private static void carregarItensPadrao() {
        
    }
    
    
    
}