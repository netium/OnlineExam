package com.tiantianchiji.onlineexam;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application implements EmbeddedServletContainerCustomizer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8088);
    }
}