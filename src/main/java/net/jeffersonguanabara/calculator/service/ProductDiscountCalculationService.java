package net.jeffersonguanabara.calculator.service;

import net.jeffersonguanabara.calculator.model.Product;

public interface ProductDiscountCalculationService {

	Product calculate(Product product, Double discountFactor);

}
