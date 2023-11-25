package com.hashharan.rest.data;

import com.hashharan.rest.model.Provider;
import org.springframework.data.repository.ListCrudRepository;

public interface ProviderCrudRepository extends ListCrudRepository<Provider, Long> {
}
