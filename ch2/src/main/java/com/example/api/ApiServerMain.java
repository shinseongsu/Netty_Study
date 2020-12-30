package com.example.api;

import com.example.api.config.ApiServer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ApiServerMain {
    public static void main(String[] args) {
        AbstractApplicationContext springContext = null;

        try {
            springContext = new AnnotationConfigApplicationContext();
            springContext.registerShutdownHook();

            ApiServer server = springContext.getBean(ApiServer.class);
            server.start();
        } finally {
            springContext.close();
        }
    }
}
