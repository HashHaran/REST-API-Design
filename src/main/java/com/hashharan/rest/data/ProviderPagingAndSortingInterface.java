package com.hashharan.rest.data;

import com.hashharan.rest.model.Provider;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface ProviderPagingAndSortingInterface extends ListPagingAndSortingRepository<Provider, Long> {
}
