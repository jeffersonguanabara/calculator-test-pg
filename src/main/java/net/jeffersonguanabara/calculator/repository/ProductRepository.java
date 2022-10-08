package net.jeffersonguanabara.calculator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.jeffersonguanabara.calculator.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
