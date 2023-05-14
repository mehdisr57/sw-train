package com.msrazavi.train.sw.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 */
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, String>, CrudRepository<Product, String> {
}
