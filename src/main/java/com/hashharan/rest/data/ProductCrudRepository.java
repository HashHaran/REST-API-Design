package com.hashharan.rest.data;

import com.hashharan.rest.model.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductCrudRepository extends ListCrudRepository<Product, Long> {
}
