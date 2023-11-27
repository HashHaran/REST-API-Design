package com.hashharan.rest.controller;

import com.hashharan.rest.data.ProviderCrudRepository;
import com.hashharan.rest.data.ProviderPagingAndSortingInterface;
import com.hashharan.rest.exceptions.ProviderNotFoundException;
import com.hashharan.rest.model.Provider;
import com.hashharan.rest.model.ProviderDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderCrudRepository providerCrudRepository;
    private final ProviderPagingAndSortingInterface providerPagingAndSortingInterface;
    private final ModelMapper modelMapper;

    //Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("providers/")
    List<ProviderDTO> all() {
        List<Provider> providers = providerCrudRepository.findAll();
        return providers.stream().map(provider -> modelMapper.map(provider, ProviderDTO.class)).toList();
    }
    // end::get-aggregate-root[]

    @PostMapping("providers/")
    Provider newProvider(@RequestBody Provider provider) {
        return providerCrudRepository.save(provider);
    }

    @GetMapping("/providers/{id}")
    Provider one(@PathVariable Long id) {

        return providerCrudRepository.findById(id)
                .orElseThrow(() -> new ProviderNotFoundException(id));
    }

    @PutMapping("/providers/{id}")
    Provider replaceProvider(@RequestBody Provider newProvider, @PathVariable Long id) {

        return providerCrudRepository.findById(id)
                .map(provider -> {
                    provider.setName(newProvider.getName());
                    provider.setProviderType(newProvider.getProviderType());
                    provider.setDescription(newProvider.getDescription());
                    provider.setDateOfInception(newProvider.getDateOfInception());
                    return providerCrudRepository.save(provider);
                })
                .orElseGet(() -> {
                    newProvider.setId(id);
                    return providerCrudRepository.save(newProvider);
                });
    }

    @DeleteMapping("/providers/{id}")
    void deleteProvider(@PathVariable Long id) {
        providerCrudRepository.deleteById(id);
    }

}
