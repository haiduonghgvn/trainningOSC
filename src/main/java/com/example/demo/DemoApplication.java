package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.apache.log4j.Logger;


@SpringBootApplication
//Enable Caching
@EnableCaching
public class DemoApplication {
    private static final Logger logger = Logger.getLogger(String.valueOf(DemoApplication.class));

    public static void main(String[] args) {
        logger.debug("debug log");
        logger.info("info log");
        logger.error("error log");
        SpringApplication.run(DemoApplication.class, args);
    }

}