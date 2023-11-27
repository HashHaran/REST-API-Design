package com.hashharan.rest.controller;

import com.hashharan.rest.data.ProductCrudRepository;
import com.hashharan.rest.data.ProductPagingAndSortingInterface;
import com.hashharan.rest.exceptions.ProductNotFoundException;
import com.hashharan.rest.model.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductCrudRepository productCrudRepository;
    private final ProductPagingAndSortingInterface productPagingAndSortingInterface;
    private final ModelMapper modelMapper;

    //Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("products/")
    List<Product> all() {
        List<Product> products = productCrudRepository.findAll();
        return products.stream().map(product -> modelMapper.map(product, Product.class)).toList();
    }
    // end::get-aggregate-root[]

    @PostMapping("products/")
    Product newProduct(@RequestBody Product product) {
        return productCrudRepository.save(product);
    }

    @GetMapping("/products/{id}")
    Product one(@PathVariable Long id) {

        return productCrudRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PutMapping("/products/{id}")
    Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {

        return productCrudRepository.findById(id)
                .map(product -> {
                    product.setProvider(newProduct.getProvider());
                    product.setType(newProduct.getType());
                    product.setDescription(newProduct.getDescription());
                    product.setTaxExempt(newProduct.getTaxExempt());
                    return productCrudRepository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return productCrudRepository.save(newProduct);
                });
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Long id) {
        productCrudRepository.deleteById(id);
    }

}
