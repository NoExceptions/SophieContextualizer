package com.ihm.contextualizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

import java.util.Collections;

@Configuration
@EnableSwagger2WebFlux
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Sophie Contextualizer", // Strings with API information
                "swaggerApiDescription",
                "apiVersion",
                "apiTermsOfUse",
                new springfox.documentation.service.Contact("apiAuthors", "apiWebsiteUrl", "apiEmail"),
                "apiLicense",
                "apiLicenseUrl",
                Collections.emptyList());
    }
}