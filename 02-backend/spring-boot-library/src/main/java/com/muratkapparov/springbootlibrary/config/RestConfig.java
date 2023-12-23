package com.muratkapparov.springbootlibrary.config;

import com.muratkapparov.springbootlibrary.entity.Book;
import com.muratkapparov.springbootlibrary.entity.History;
import com.muratkapparov.springbootlibrary.entity.Message;
import com.muratkapparov.springbootlibrary.entity.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {
    private String theAllowedOrigins = "http://localhost:3000";
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors){
        HttpMethod[] unsupportedActions = {HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH, HttpMethod.PUT};
        config.exposeIdsFor(Book.class, Review.class, Message.class);
        dissableHttpMethods(Book.class, config , unsupportedActions);
        dissableHttpMethods(Review.class, config, unsupportedActions);
        dissableHttpMethods(Message.class, config, unsupportedActions);
        /* CORS config */
        cors.addMapping(config.getBasePath() + "/**")
                .allowedOrigins(theAllowedOrigins);
    }
    private void dissableHttpMethods(Class theClass , RepositoryRestConfiguration configuration, HttpMethod[] unsupportedActions){
        configuration
                .getExposureConfiguration()
                .forDomainType(theClass)
                .withAssociationExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedActions)));
    }
}
