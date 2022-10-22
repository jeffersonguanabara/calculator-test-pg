package net.jeffersonguanabara.calculator.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import net.jeffersonguanabara.calculator.model.Product;
import net.jeffersonguanabara.calculator.repository.ProductRepository;

@SpringBootTest
@DisplayName("MOCK: Testes do Controlador de Cálculo do Desconto no Preço do Produto")
public class CalculatorControllerV1IntegrationTests {

	@Autowired
	CalculatorControllerV1 driver;
	@MockBean
	ProductRepository productRepository;
	
	String clientType;
	
	@BeforeEach
	void setup() {
		Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(new Product(1L, 100.00)));
		Mockito.when(productRepository.findById(2L)).thenReturn(Optional.of(new Product(2L, 100.00)));
	}
	
	@Nested
	@DisplayName("Quando o cliente é do tipo 'A'")
	class ClientTypeA {
		
		@BeforeEach
		void setup() {
			clientType = "A";
		}
		
		@Test
		@DisplayName("E quantidade entre 1 até 99")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo1LessThen100THENProductPrice90() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 1;
			Integer quantityMax = 99;
			/* Act */
			Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
			Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
			/* Assert */
			assertThat(productMin.getPrice(), is(90.00));
			assertThat(productMax.getPrice(), is(90.00));
		}
		
		@Test
		@DisplayName("E quantidade entre 100 até 999")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo100LessThen1000THENProductPrice95() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 100;
			Integer quantityMax = 999;
			/* Act */
			Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
			Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
			/* Assert */
			assertThat(productMin.getPrice(), is(95.00));
			assertThat(productMax.getPrice(), is(95.00));
		}
		
		@Test
		@DisplayName("E quantidade acima de 1000")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo1000LessThen100THENProductPrice100() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 1000;
			Integer quantityMax = 9999;
			/* Act */
			Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
			Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
			/* Assert */
			assertThat(productMin.getPrice(), is(100.00));
			assertThat(productMax.getPrice(), is(100.00));
		}
	} 
	
	@Nested
	@DisplayName("Quando o cliente é do tipo 'B'")
	class ClientTypeB {
		
		@BeforeEach
		void setup() {
			clientType = "B";
		}
		
		@Test
		@DisplayName("E quantidade entre 1 até 99")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo1LessThen100THENProductPrice90() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 1;
			Integer quantityMax = 99;
			/* Act */
			Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
			Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
			/* Assert */
			assertThat(productMin.getPrice(), is(85.00));
			assertThat(productMax.getPrice(), is(85.00));
		}
		
		@Test
		@DisplayName("E quantidade entre 100 até 999")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo100LessThen1000THENProductPrice95() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 100;
			Integer quantityMax = 999;
			/* Act */
			Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
			Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
			/* Assert */
			assertThat(productMin.getPrice(), is(90.00));
			assertThat(productMax.getPrice(), is(90.00));
		}
		
		@Test
		@DisplayName("E quantidade acima de 1000")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo1000LessThen100THENProductPrice100() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 1000;
			Integer quantityMax = 9999;
			/* Act */
			Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
			Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
			/* Assert */
			assertThat(productMin.getPrice(), is(95.00));
			assertThat(productMax.getPrice(), is(95.00));
		}
	} 

	@Nested
	@DisplayName("Quando o cliente é do tipo 'C'")
	class ClientTypeC {
	
		@BeforeEach
		void setup() {
			clientType = "C";
		}
		
		@Test
		@DisplayName("E quantidade entre 1 até 99")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo1LessThen100THENProductPrice90() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 1;
			Integer quantityMax = 99;
			/* Act */
			Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
			Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
			/* Assert */
			assertThat(productMin.getPrice(), is(80.00));
			assertThat(productMax.getPrice(), is(80.00));
		}
		
		@Test
		@DisplayName("E quantidade entre 100 até 999")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo100LessThen1000THENProductPrice95() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 100;
			Integer quantityMax = 999;
			/* Act */
			Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
			Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
			/* Assert */
			assertThat(productMin.getPrice(), is(85.00));
			assertThat(productMax.getPrice(), is(85.00));
		}
		
		@Test
		@DisplayName("E quantidade acima de 1000")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo1000LessThen100THENProductPrice100() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 1000;
			Integer quantityMax = 9999;
			/* Act */
			Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
			Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
			/* Assert */
			assertThat(productMin.getPrice(), is(90.00));
			assertThat(productMax.getPrice(), is(90.00));
		}
	} 
}
