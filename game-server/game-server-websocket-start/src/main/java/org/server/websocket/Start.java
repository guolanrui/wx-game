package org.server.websocket;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy
public class Start {

	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Start.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
