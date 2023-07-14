/**
 * 
 */
package com.dynotes.webservices.springbootswagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

/**
 * @author Yufeng Chen
 */
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "${api.info.title}"
					, version = "${api.info.version}" 
					, description = "${api.info.description}"
	, contact = @Contact(name = "${api.contact.name}"
						, url = "${api.contact.url}"
						, email = "${api.contact.email}")
	, license = @License(name = "${api.license.name}"
							, url = "${api.license.url}"))
	, security = {@SecurityRequirement(name = "${api.auth.header.name}") }
)
@SecurityScheme(type = SecuritySchemeType.APIKEY, name = "${api.auth.header.name}", in = SecuritySchemeIn.HEADER)
public class RestfulAPIWithSwagger2Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestfulAPIWithSwagger2Application.class, args);

	}

}
