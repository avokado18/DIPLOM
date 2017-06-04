package com.diplom.backend.app;

import com.diplom.backend.MainConf;
import com.diplom.backend.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
@Import({WebSecurityConfig.class})
public class Launcher {
    public static void main(String[] args) {
        SpringApplication.run(MainConf.class);
    }
}
