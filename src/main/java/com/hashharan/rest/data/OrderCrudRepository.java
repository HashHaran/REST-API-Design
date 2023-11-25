package com.hashharan.rest.data;

import com.hashharan.rest.model.Order;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderCrudRepository extends ListCrudRepository<Order, Long> {
}
