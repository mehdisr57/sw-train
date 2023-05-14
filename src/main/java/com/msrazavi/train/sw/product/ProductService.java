package com.msrazavi.train.sw.product;

import com.msrazavi.train.sw.err.ProductIdNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 */
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

    @Transactional
    public Product save(Product product) {
        return repository.save(product);
    }


    @Transactional
    public void delete(String id) {
        validateId(id);
        final Product entity = new Product();
        entity.setId(id);
        repository.delete(entity);
    }

    private static void validateId(String id) {
        ProductIdNotFoundException.checkAndThrowException(id);
    }
}
