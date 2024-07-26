package com.vtd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * TestApplication
 * Version 1.0
 * Date: 26/07/2024
 * Copyright
 * Modification Logs
 * DATE          AUTHOR          DESCRIPTION
 * ------------------------------------------------
 * 26/07/2024        NGUYEN             create
 */

@SpringBootApplication
@EnableJpaAuditing
public class TestApplication {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class,args);
    }
}
