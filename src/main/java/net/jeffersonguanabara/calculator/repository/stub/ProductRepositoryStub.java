package net.jeffersonguanabara.calculator.repository.stub;

import net.jeffersonguanabara.calculator.model.Product;

public class ProductRepositoryStub {

	public Product findById(Long id) {
		return new Product(1L, 100.00);
	}

}
