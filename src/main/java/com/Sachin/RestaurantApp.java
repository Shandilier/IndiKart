package com.Sachin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.Sachin.Model.CanFulfill")
@SpringBootApplication
class RestaurantApp {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantApp.class,args);
    }
}
