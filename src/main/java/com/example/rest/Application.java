package com.example.rest;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;
/**
 * @author Pavel Bucek (pavel.bucek at oracle.com)
 */
@ApplicationPath("/")
public class Application extends javax.ws.rs.core.Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(JacksonConfigurator.class);
        classes.add(BeersResource.class);
        classes.add(ExportResource.class);
        return classes;
    }
}