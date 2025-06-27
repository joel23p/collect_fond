package com.collect.fond;

import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;


import static io.swagger.v3.oas.annotations.enums.SecuritySchemeIn.HEADER;
import static io.swagger.v3.oas.annotations.enums.SecuritySchemeType.APIKEY;

@SpringBootApplication
@SecurityScheme(name = "Authorization", scheme = "basic", type = APIKEY, in = HEADER)
public class CollectFondApplication extends SpringBootServletInitializer {
	public static final Logger log = LoggerFactory.getLogger(CollectFondApplication.class);

	public static void main(String[] args) throws IOException {
		/*
		String pubDirPath = System.getProperty("user.dir") + "/publications" ;
		Files.createDirectories(Paths.get(pubDirPath));
		Files.createDirectories(Paths.get(pubDirPath + "/actes_mariage"));
		 */
		SpringApplication.run(CollectFondApplication.class, args);
		log.info("""

				================================================================================================
				                                   COLLECTE DE FOND  STARTED...
				================================================================================================"""
		);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CollectFondApplication.class);
	}

}
