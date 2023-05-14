package com.msrazavi.train.sw.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Page<Product> findAll(Pageable pageable) {
        if (pageable == null) {
            throw new IllegalArgumentException("pageable is not valid");
        }
        return repository.findAll(pageable);
    }

    public Optional<Product> findById(String id) {
        validateId(id);
        return repository.findById(id);

    }

    public Product save(Product product) {
        return repository.save(product);

    }

    public void delete(String id) {
        validateId(id);
        final Product entity = new Product();
        entity.setId(id);
        repository.delete(entity);
    }

    private static void validateId(String id) {
        if (id == null) {
            throw new IllegalArgumentException("id is not valid");
        }
    }
}
