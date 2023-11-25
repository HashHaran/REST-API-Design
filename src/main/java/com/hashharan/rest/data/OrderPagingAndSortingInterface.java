package com.hashharan.rest.data;

import com.hashharan.rest.model.Order;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface OrderPagingAndSortingInterface extends ListPagingAndSortingRepository<Order, Long> {
}
