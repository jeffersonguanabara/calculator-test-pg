package net.jeffersonguanabara.calculator.repository.stub;

import net.jeffersonguanabara.calculator.model.Product;
import net.jeffersonguanabara.calculator.repository.ProductRepository;

public class ProductRepositoryStub implements ProductRepository {

	@Override
	public Product findById(Long id) {
		return new Product(1L, 100.00);
	}

}
