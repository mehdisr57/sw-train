package com.msrazavi.train.sw.price;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 */
@Repository
public interface ProductPriceRepository extends CrudRepository<ProductPrice, String> {

    @Modifying
    @Query("update ProductPrice p " +
            "set p.active = null " +
            "where p.product.id = :productId")
    void deActivePricesOfProduct(@Param("productId") String productId);

    @Query("select p " +
            "from ProductPrice p " +
            "where p.product.id = :productId")
    List<ProductPrice> findByProductId(@Param("productId") String productId);
}
