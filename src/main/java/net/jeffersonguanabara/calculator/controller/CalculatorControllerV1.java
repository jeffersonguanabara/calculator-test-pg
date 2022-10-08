package net.jeffersonguanabara.calculator.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.jeffersonguanabara.calculator.model.Product;
import net.jeffersonguanabara.calculator.repository.ProductRepository;
import net.jeffersonguanabara.calculator.service.DiscountFactorCalculationService;
import net.jeffersonguanabara.calculator.service.ProductDiscountCalculationService;

@RestController
@RequestMapping(
		value = "/calculator/v1",
		produces = MediaType.APPLICATION_JSON_VALUE
)
public class CalculatorControllerV1 {
	
	@Autowired
	DiscountFactorCalculationService discountFactorCalculationService;
	@Autowired
	ProductDiscountCalculationService productDiscountCalculationService;
	@Autowired
	ProductRepository productRepository;

	public Product getProductWithDiscount(Long id, String clientType, Integer quantity) {
		Double discountFactor = discountFactorCalculationService.calculate(clientType, quantity);
		Optional<Product> productOptional = productRepository.findById(id);
		Product product;
		if (productOptional.isPresent()) {
			product = productOptional.get();
			return productDiscountCalculationService.calculate(product, discountFactor);
		}
		return null;
	}

}
