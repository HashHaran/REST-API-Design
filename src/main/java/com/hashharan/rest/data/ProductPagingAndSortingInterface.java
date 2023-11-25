package com.hashharan.rest.data;

import com.hashharan.rest.model.Product;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface ProductPagingAndSortingInterface extends ListPagingAndSortingRepository<Product, Long> {
}
