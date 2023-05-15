package com.msrazavi.train.sw.product;

import com.msrazavi.train.sw.err.ProductIdNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 */
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    public Page<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("p1"));
        products.add(new Product("p2"));
        products.add(new Product("p3"));
        return new PageImpl<>(products);
    }

    @Test
    void validateIdTest() {
        Assertions.assertThrows(ProductIdNotFoundException.class, () -> service.delete(null));
    }

    @Test
    void findAllTest() {
        final PageRequest pageRequest = PageRequest.of(0, 10);
        Mockito.when(repository.findAll(pageRequest)).then(invocation -> getProducts());
        final Page<Product> all = service.findAll(pageRequest);
        Assertions.assertEquals(all.getContent().size(), 3);
    }
}
