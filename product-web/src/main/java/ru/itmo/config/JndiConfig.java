package ru.itmo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itmo.service.ProductBean;

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
    public ProductBean productBeanStateless(Context context) throws NamingException {
        return (ProductBean) context.lookup("product-ejb/ProductBean!ru.itmo.service.ProductInterface");
    }

}
