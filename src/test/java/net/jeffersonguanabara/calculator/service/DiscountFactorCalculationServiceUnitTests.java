package net.jeffersonguanabara.calculator.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@DisplayName("Testes do Serviço de Cálculo do Fator de Desconto")
public class DiscountFactorCalculationServiceUnitTests {

	@Autowired
	DiscountFactorCalculationService driver;
	
	String clientType;
		
	@Nested
	@DisplayName("Quando o cliente é do tipo 'A'")
	class ClientTypeA {
		
		@BeforeEach
		public void setup() {
			clientType = "A";
		}
		
		@Test
		@DisplayName("E quantidade entre 1 até 99")
		public void whenClientaQuantityLessThen100ThenDiscount10Percent() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 1;
			Integer quantityMax = 99;
			/** Act */
			Double resultMin = driver.calculate(clientType, quantityMin);
			Double resultMax = driver.calculate(clientType, quantityMax);
			/** Assert */
			assertThat(resultMin, is(0.90));
			assertThat(resultMax, is(0.90));
		}
		
		@Test
		@DisplayName("E quantidade entre 100 até 999")
		public void whenClientaQuantityMoreThen100LessThen1000ThenDiscount05Percent() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 100;
			Integer quantityMax = 999;
			/** Act */
			Double resultMin = driver.calculate(clientType, quantityMin);
			Double resultMax = driver.calculate(clientType, quantityMax);
			/** Assert */
			assertThat(resultMin, is(0.95));
			assertThat(resultMax, is(0.95));
		}
		
		@Test
		@DisplayName("E quantidade acima de 1000")
		public void whenClientaQuantityMoreThen1000ThenDiscount00Percent() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 1000;
			Integer quantityMax = 9999;
			/** Act */
			Double resultMin = driver.calculate(clientType, quantityMin);
			Double resultMax = driver.calculate(clientType, quantityMax);
			/** Assert */
			assertThat(resultMin, is(1.0));
			assertThat(resultMax, is(1.0));
		}
		
		@AfterEach
		public void tearDown() {
			clientType = null;
		}
	}
	
	@Nested
	@DisplayName("Quando o cliente é do tipo 'B'")
	class ClientTypeB {
		
		@BeforeEach
		public void setup() {
			clientType = "B";
		}
		
		@Test
		@DisplayName("E quantidade entre 1 até 99")
		public void whenClientaQuantityLessThen100ThenDiscount15Percent() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 1;
			Integer quantityMax = 99;
			/** Act */
			Double resultMin = driver.calculate(clientType, quantityMin);
			Double resultMax = driver.calculate(clientType, quantityMax);
			/** Assert */
			assertThat(resultMin, is(0.85));
			assertThat(resultMax, is(0.85));
		}
		
		@Test
		@DisplayName("E quantidade entre 100 até 999")
		public void whenClientaQuantityMoreThen100LessThen1000ThenDiscount10Percent() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 100;
			Integer quantityMax = 999;
			/** Act */
			Double resultMin = driver.calculate(clientType, quantityMin);
			Double resultMax = driver.calculate(clientType, quantityMax);
			/** Assert */
			assertThat(resultMin, is(0.90));
			assertThat(resultMax, is(0.90));
		}
		
		@Test
		@DisplayName("E quantidade acima de 1000")
		public void whenClientaQuantityMoreThen1000ThenDiscount05Percent() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 1000;
			Integer quantityMax = 9999;
			/** Act */
			Double resultMin = driver.calculate(clientType, quantityMin);
			Double resultMax = driver.calculate(clientType, quantityMax);
			/** Assert */
			assertThat(resultMin, is(0.95));
			assertThat(resultMax, is(0.95));
		}
		
		@AfterEach
		public void tearDown() {
			clientType = null;
		}
	}
	
	@Nested
	@DisplayName("Quando o cliente é do tipo 'C'")
	class ClientTypeC {
		
		@BeforeEach
		public void setup() {
			clientType = "C";
		}
		
		@Test
		@DisplayName("E quantidade entre 1 até 99")
		public void whenClientaQuantityLessThen100ThenDiscount20Percent() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 1;
			Integer quantityMax = 99;
			/** Act */
			Double resultMin = driver.calculate(clientType, quantityMin);
			Double resultMax = driver.calculate(clientType, quantityMax);
			/** Assert */
			assertThat(resultMin, is(0.80));
			assertThat(resultMax, is(0.80));
		}
		
		@Test
		@DisplayName("E quantidade entre 100 até 999")
		public void whenClientaQuantityMoreThen100LessThen1000ThenDiscount15Percent() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 100;
			Integer quantityMax = 999;
			/** Act */
			Double resultMin = driver.calculate(clientType, quantityMin);
			Double resultMax = driver.calculate(clientType, quantityMax);
			/** Assert */
			assertThat(resultMin, is(0.85));
			assertThat(resultMax, is(0.85));
		}
		
		@Test
		@DisplayName("E quantidade acima de 1000")
		public void whenClientaQuantityMoreThen1000ThenDiscount10Percent() {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantityMin = 1000;
			Integer quantityMax = 9999;
			/** Act */
			Double resultMin = driver.calculate(clientType, quantityMin);
			Double resultMax = driver.calculate(clientType, quantityMax);
			/** Assert */
			assertThat(resultMin, is(0.90));
			assertThat(resultMax, is(0.90));
		}
		
		@AfterEach
		public void tearDown() {
			clientType = null;
		}
	}
	
}
