package com.samsung;

import com.samsung.dao.BookDao;
import com.samsung.domain.Book;
import com.samsung.service.LibraryDemo;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;
import java.util.List;

// url h2 консоли: http://localhost:8080/h2-console
// url базы: jdbc:h2:mem:testdb

@SpringBootApplication
public class LibraryApp {

    public static void main(String[] args) {

        //Запуск SpringBoot-приложения и получение контекста
        ConfigurableApplicationContext context = SpringApplication.run(LibraryApp.class, args);

        LibraryDemo libraryDemo = context.getBean(LibraryDemo.class);
        libraryDemo.libDemo();

        context.close();

        /*try {
            //Консоль для визуализации бд в браузере
            Console.main(args);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

    }
}
