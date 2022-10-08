package net.jeffersonguanabara.calculator.service;

import org.springframework.stereotype.Service;

import net.jeffersonguanabara.calculator.model.Product;

@Service
public class ProductDiscountCalculationImplService implements ProductDiscountCalculationService {

	@Override
	public Product calculate(Product product, Double discountFactor) {
		product.setPrice(product.getPrice() * discountFactor);
		
		return product;
	}

}
