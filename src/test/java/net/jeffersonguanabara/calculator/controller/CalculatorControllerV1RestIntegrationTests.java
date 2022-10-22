package net.jeffersonguanabara.calculator.controller;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.jeffersonguanabara.calculator.model.Product;
import net.jeffersonguanabara.calculator.repository.ProductRepository;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("REST INTEGRATION: Testes do Controller do cálculo do Desconto no Preço do Produto")
public class CalculatorControllerV1RestIntegrationTests {

	final static String BASE_URI = "/calculator/v1";
	final static Long DEFAULT_PRODUCT_ID = 1L;
	
	@Autowired
	MockMvc driver;
	@Autowired
	ProductRepository productRepository;
	
	Product productDefault = new Product(DEFAULT_PRODUCT_ID, 100.00);
	
	String clientType;
	
	@BeforeEach
	void setup() {
		/** Arrange */
		productRepository.save(productDefault);
	}
	
	@Nested
	@DisplayName("Quando o cliente é do tipo 'A'")
	class ClientTypeA {
		@BeforeEach
		void setup() {
			/** Arrange */
			clientType = "A";
		}
		
		@Test
		@DisplayName("E quantidade entre 1 até 99")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo1LessThen100THENProductPrice90() throws Exception {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantity = 1;
			
			/* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

			
			 /* Assert */
            assertThat(result.getPrice(), is(90.00));

		}
		
		@Test
		@DisplayName("E quantidade entre 100 até 999")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo100LessThen1000THENProductPrice95() throws Exception {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantity = 200;
			
			/* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

			
			 /* Assert */
            assertThat(result.getPrice(), is(95.00));

		}
		
		@Test
		@DisplayName("E quantidade acima de 1000")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo100LessThen100THENProductPrice100() throws Exception {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantity = 1000;
			
			/* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

			
			 /* Assert */
            assertThat(result.getPrice(), is(100.00));

		}
	}
	
	@Nested
	@DisplayName("Quando o cliente é do tipo 'B'")
	class ClientTypeB {
		@BeforeEach
		void setup() {
			/** Arrange */
			clientType = "B";
		}
		
		@Test
		@DisplayName("E quantidade entre 1 até 99")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo1LessThen100THENProductPrice85() throws Exception {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantity = 1;
			
			/* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

			
			 /* Assert */
            assertThat(result.getPrice(), is(85.00));

		}
		
		@Test
		@DisplayName("E quantidade entre 100 até 999")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo100LessThen1000THENProductPrice90() throws Exception {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantity = 200;
			
			/* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

			
			 /* Assert */
            assertThat(result.getPrice(), is(90.00));

		}
		
		@Test
		@DisplayName("E quantidade entre 100 até 999")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo100LessThen100THENProductPrice95() throws Exception {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantity = 1000;
			
			/* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

			
			 /* Assert */
            assertThat(result.getPrice(), is(95.00));

		}
	}
	
	@Nested
	@DisplayName("Quando o cliente é do tipo 'C'")
	class ClientTypeC {
		@BeforeEach
		void setup() {
			/** Arrange */
			clientType = "C";
		}
		
		@Test
		@DisplayName("E quantidade entre 1 até 99")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo1LessThen100THENProductPrice80() throws Exception {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantity = 1;
			
			/* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

			
			 /* Assert */
            assertThat(result.getPrice(), is(80.00));

		}
		
		@Test
		@DisplayName("E quantidade entre 100 até 999")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo100LessThen1000THENProductPrice85() throws Exception {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantity = 200;
			
			/* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

			
			 /* Assert */
            assertThat(result.getPrice(), is(85.00));

		}
		
		@Test
		@DisplayName("E quantidade entre 100 até 999")
		void whenProductIsPrice100AndClientTypeIsAAndQunatityGreaterEqualsTo100LessThen100THENProductPrice90() throws Exception {
			// AAA Pattern => Arrange, then Act, finally Assert 
			/** Arrange */
			Integer quantity = 1000;
			
			/* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

			
			 /* Assert */
            assertThat(result.getPrice(), is(90.00));

		}
	}
	
	@AfterEach
	void tearDown() {
		productRepository.delete(productDefault);
	}
}

