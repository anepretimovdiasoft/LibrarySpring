package com.samsung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LibraryApp {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(LibraryApp.class, args);

    }
}
