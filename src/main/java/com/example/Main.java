package com.example;

import com.example.rest.Application;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.LoggerFactory;

import java.net.URI;

/**
 *
 */
public class Main {
    private static final URI BASE_URI = URI.create("http://localhost:3000/");
    public static final String ROOT_PATH = "";

    public static void main(String[] args) {
        try {
            final ResourceConfig resourceConfig = new ResourceConfig();
            new Application().getClasses().forEach((Class resourceClass) -> resourceConfig.register(resourceClass));
            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, resourceConfig);
            System.out.println(String.format("Example App Started...",
                BASE_URI, ROOT_PATH));
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    server.shutdownNow();
                }
            });

            while (true) {
                System.in.read();
            }

        } catch (Throwable t) {
            LoggerFactory.getLogger(Main.class).error("main", t);
        }
    }
}
