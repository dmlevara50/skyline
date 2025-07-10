package com.skyline;

import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication(scanBasePackages={"com.skyline"})
@EntityScan(basePackages = {"com.skyline"})
@EnableElasticsearchRepositories(basePackages = "com.skyline")
public class SkylineApplication {

    public static void main(String[] args) throws SchedulerException {
        SpringApplication.run(SkylineApplication.class, args);
    }

}
