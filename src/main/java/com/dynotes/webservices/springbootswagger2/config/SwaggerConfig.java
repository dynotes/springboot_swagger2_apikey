/**
 * 
 */
package com.dynotes.webservices.springbootswagger2.config;

import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Yufeng Chen. Modified from ChatGPT
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * Original from ChatGPT
	 * Modified by Yufeng Chen
	 */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dynotes.webservices"))
                .paths(PathSelectors.any())
                .build()
                ;
    }

    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Dynotes API samples")
//                .description("Dynotes API samples using Spring Boot and Swagger")
//                .version("1.0")
//                .build();
    	return new ApiInfo(
    	        "Dynotes API samples",
    	        "Dynotes API samples using Spring Boot and Swagger",
    	        "0.1",
    	        "",
    	        new Contact("Support", "https://dynotes.com", "support@dynotes.com"),
    	        "",
    	        "",
    	        Collections.emptyList());
    }
}
