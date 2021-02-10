package com.lonewolf.memeStream.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * This class acts as Configuration class for generating Swagger Documentation
 * for Spring Boot API <br>
 * This class uses
 * {@link com.lonewolf.memeStream.config.SwaggerConfigRepository} as repository
 * to take information regarding API title, version, developer email address
 * etc.
 * </p>
 * 
 * @author Subham Das
 * @version 1.0
 * @see {@link com.lonewolf.memeStream.controller.MemeController}
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
	/**
	 * This method configures Docket object to be used and returns the Docket object
	 * 
	 * @return Docket object to used by Swagger
	 */
	@Bean
	public Docket configureMemeApiDocket() {
		Docket apiDocket = new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(SwaggerConfigRepository.Base_Package))
				.paths(PathSelectors.regex("/memes.*")).build().apiInfo(metaApiInfo());

		return apiDocket;
	}

	/**
	 * This method configures Swagger Configuration with custom API and developer
	 * information
	 * 
	 * @return {@link springfox.documentation.service.ApiInfo}
	 */
	private ApiInfo metaApiInfo() {
		Contact developerContact = new Contact(SwaggerConfigRepository.Developer_Name,
				SwaggerConfigRepository.Developer_Website, SwaggerConfigRepository.Developer_Email);

		ApiInfo apiInfo = new ApiInfo(SwaggerConfigRepository.Api_Title, SwaggerConfigRepository.Api_Description,
				SwaggerConfigRepository.Api_Version, null, developerContact, SwaggerConfigRepository.Api_License,
				SwaggerConfigRepository.Api_License_Url, Collections.emptyList());
		return apiInfo;
	}
}
