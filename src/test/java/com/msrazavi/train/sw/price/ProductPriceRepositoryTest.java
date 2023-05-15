package com.msrazavi.train.sw.price;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@SqlGroup({
        @Sql(value = "classpath:sql/data-h2.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
})
class ProductPriceRepositoryTest {

    private final String productId = "#3";

    @Autowired
    private ProductPriceRepository repository;
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void findByProductIdTest() {
        Assertions.assertEquals(3, repository.findByProductId(productId).size());
    }

    @Test
    void deActivePricesOfProductTest() {
        final long initDeActiveCount = repository.findByProductId(productId).stream()
                .filter(productPrice -> Objects.isNull(productPrice.getActive()))
                .count();
        repository.deActivePricesOfProduct(productId);
        entityManager.clear();
        final long deActiveCount = repository.findByProductId(productId).stream()
                .filter(productPrice -> Objects.isNull(productPrice.getActive()))
                .count();
        Assertions.assertNotEquals(initDeActiveCount, deActiveCount);
    }
}
