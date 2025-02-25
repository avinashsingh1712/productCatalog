package com.poc.productcatalog;

import com.poc.productcatalog.data.MockData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@Slf4j
@EnableConfigurationProperties
public class ProductCatalogApplication {

	public static void main(String[] args) {
		log.warn("Start Cloud Run Demo application");
		SpringApplication.run(ProductCatalogApplication.class, args);
	}
}
