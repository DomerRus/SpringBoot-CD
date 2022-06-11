package ru.itmo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import ru.itmo.service.ProductService;
import ru.itmo.service.impl.ProductServiceImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

@Configuration
public class JndiConfig {


    @Bean
    public Context context() throws NamingException {
        Properties jndiProps = new Properties();
        jndiProps.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProps.put("jboss.naming.client.ejb.context", true);
        jndiProps.put("java.naming.provider.url", "http-remoting://127.0.0.1:8080");
        return new InitialContext(jndiProps);
    }



    @Bean
    public ProductService helloStatelessWorld(Context context) throws NamingException {
        return (ProductService) context.lookup(this.getFullName(ProductService.class));
    }

    private String getFullName(Class classType) {
        String moduleName = "product-ejb/";
        String beanName = classType.getSimpleName();
        String viewClassName = classType.getName();

        return moduleName + beanName + "!" + viewClassName;
    }
}
