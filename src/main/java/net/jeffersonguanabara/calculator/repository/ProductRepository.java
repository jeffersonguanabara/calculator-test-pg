package net.jeffersonguanabara.calculator.repository;

import net.jeffersonguanabara.calculator.model.Product;

public interface ProductRepository {

	Product findById(Long id);
}
