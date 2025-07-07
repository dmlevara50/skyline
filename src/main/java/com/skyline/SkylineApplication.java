package com.skyline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.skyline"})
@EntityScan(basePackages = {"com.skyline"})
public class SkylineApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkylineApplication.class, args);
    }

}
