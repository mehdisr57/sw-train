package com.msrazavi.train.sw.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.stream.StreamSupport;

/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 */
@DataJpaTest
@SqlGroup({
        @Sql(value = "classpath:sql/data-h2.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
})
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    void insertTest() {
        Product product = new Product();
        product.setName("My Product");
        final Product saved = repository.save(product);
        Assertions.assertNotNull(saved.getId());
    }

    @Test
    void getAllTest() {
        final Iterable<Product> all = this.repository.findAll();
        final long count = StreamSupport.stream(all.spliterator(), false).count();
        Assertions.assertEquals(4, count);
    }

    @Test
    void getByIdTest() {
        final Iterable<Product> all = this.repository.findAll();
        final long count = StreamSupport.stream(all.spliterator(), false)
                .filter(product -> "#1".equals(product.getId()))
                .count();
        Assertions.assertEquals(1, count);
    }

    @Test
    void deleteTest() {
        final Iterable<Product> all = this.repository.findAll();
        final long initCount = StreamSupport.stream(all.spliterator(), false)
                .count();
        this.repository.delete(all.iterator().next());
        final long afterDeleteCount = StreamSupport.stream(this.repository.findAll().spliterator(), false)
                .count();
        Assertions.assertEquals(initCount - 1, afterDeleteCount);
    }

}
