package com.mansour.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mansour.demo.models.User;
import com.mansour.demo.services.UserService;

@Component
public class DatabaseManager implements CommandLineRunner {

    private JdbcTemplate jdbcTemplate;
    
    private UserService userService;

    

    public DatabaseManager(JdbcTemplate jdbcTemplate, UserService userService) {
        this.jdbcTemplate = jdbcTemplate;
        this.userService = userService;
    }



    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute("DROP TABLE IF EXISTS USER");
        jdbcTemplate.execute("CREATE TABLE `user` (`id` int NOT NULL AUTO_INCREMENT, `name` varchar(50) DEFAULT NULL, `gender` varchar(50) DEFAULT NULL, `age` int DEFAULT NULL, PRIMARY KEY (`id`))");
        if (userService.count() ==0) {
            userService.createUser(new User("Mahmoud", "Male", 27));
            userService.createUser(new User("Ahmed", "Male", 18));
        }


    }

}
