package com.treino.crud;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudSpringbootApplication {

    public static void main(String[] args) {
        // Carrega o arquivo .env para as variáveis de sistema do Java
        Dotenv dotenv = Dotenv.load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

        SpringApplication.run(CrudSpringbootApplication.class, args);
    }
}