package com.msrazavi.train.sw;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 */
@SpringBootApplication
public class TrainApp {

    public static void main(String... args) {
        new SpringApplicationBuilder()
                .sources(TrainApp.class)
                .run(args);
    }
}
