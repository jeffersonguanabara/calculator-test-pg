package net.jeffersonguanabara.calculator.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import net.jeffersonguanabara.calculator.model.Product;
import net.jeffersonguanabara.calculator.repository.ProductRepository;

@SpringBootTest
public class CalculatorControllerV1IntegrationTests {

	@Autowired
	CalculatorControllerV1 driver;
	@MockBean
	ProductRepository productRepository;
	
	@BeforeEach
	void setup() {
		Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(new Product(1L, 100.00)));
		Mockito.when(productRepository.findById(2L)).thenReturn(Optional.of(new Product(2L, 100.00)));
	}
	
	@Test
	void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo1LessThen100THENProductPrice90() {
		// AAA Pattern => Arrange, then Act, finally Assert 
		/** Arrange */
		String clientType = "A";
		Integer quantityMin = 1;
		Integer quantityMax = 99;
		/* Act */
		Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
		Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
		/* Assert */
		assertThat(productMin.getPrice(), is(90.00));
		assertThat(productMax.getPrice(), is(90.00));
	}
	 
}
