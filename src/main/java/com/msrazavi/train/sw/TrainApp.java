package com.msrazavi.train.sw;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TrainApp {

    public static void main(String... args) {
        new SpringApplicationBuilder()
                .main(TrainApp.class)
                .run(args);
    }
}
