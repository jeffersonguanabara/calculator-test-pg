package net.jeffersonguanabara.calculator.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import net.jeffersonguanabara.calculator.model.Product;
import net.jeffersonguanabara.calculator.repository.ProductRepository;

public class CalculatorControllerV1RestIntegrationTests {

	final static String BASE_URI = "/calculator/v1";
	final static Long DEFAULT_PRODUCT_ID = 1L;
	
	@Autowired
	MockMvc driver;
	@Autowired
	ProductRepository productRepository;
	
	Product productDefault = new Product(DEFAULT_PRODUCT_ID, 100.00);
	
	@BeforeEach
	void setup() {
		/** Arrange */
		productRepository.save(productDefault);
	}
	
	@AfterEach
	void tearDown() {
		productRepository.delete(productDefault);
	}
	
	@Test
	void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo1LessThen100THENProductPrice90() {
		// AAA Pattern => Arrange, then Act, finally Assert 
		/** Arrange */
		String clientType = "A";
		Integer quantity = 1;
		
		/* Act */
		String responseJsonString = driver.perform(get(BASE_URI))
						.param("clientType", clientType)
						.param("quantity", String.valueOf(quantity))
						.param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn().getResponse().getContentAsString();
	}
}

