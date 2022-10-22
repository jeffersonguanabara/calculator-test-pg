package net.jeffersonguanabara.calculator.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.jeffersonguanabara.calculator.model.Product;
import net.jeffersonguanabara.calculator.repository.stub.ProductRepositoryStub;

@SpringBootTest
@DisplayName("STUB: Testes do Serviço de Cálculo do Desconto no Preço do Produto")
public class ProductDiscountCalculationServiceIntegrationTest {
	
	@Autowired
	ProductDiscountCalculationService driver;
	static ProductRepositoryStub productRepository;
	
	@BeforeEach
	public void setup() {
		productRepository = new ProductRepositoryStub();
	}
	
	@Test
	@DisplayName("Quando o Desconto é de 10% ENTÃO Preço do Produto cai de $100 para $90")
	public void whenDiscountIs10PercentThenProductPricesLower10Percent() {
		// AAA Pattern => Arrange, then Act, finally Assert 
		/** Arrange */
		Double discountFactor = 0.90;
		Product product = productRepository.findById(1L);
		
		/** Act */
		Product result = driver.calculate(product, discountFactor);
		
		/** Assert */
		assertThat(result.getPrice(), is(90.00));
	}
}
