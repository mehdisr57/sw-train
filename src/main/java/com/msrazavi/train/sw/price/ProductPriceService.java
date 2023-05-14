package com.msrazavi.train.sw.price;

import com.msrazavi.train.sw.base.BaseEntity;
import com.msrazavi.train.sw.product.Product;
import com.msrazavi.train.sw.product.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 */
@Service
public class ProductPriceService {

    private final ProductPriceRepository repository;
    private final ProductRepository productRepository;

    public ProductPriceService(ProductPriceRepository repository,
                               ProductRepository productRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductPrice setPrice(ProductPrice productPrice) {
        if (productPrice == null){
            throw new IllegalArgumentException("productPrice is not valid");
        }

        if (Optional.of(productPrice)
                .map(ProductPrice::getPrice)
                .isEmpty()) {
            throw new IllegalArgumentException("price is not valid");
        }

        final Product product = Optional.of(productPrice)
                .map(ProductPrice::getProduct)
                .map(BaseEntity::getId)
                .flatMap(productRepository::findById)
                .orElseThrow(() -> new IllegalArgumentException("productId is not valid"));

        this.repository.deActivePricesOfProduct(product.getId());

        productPrice.setPriceDate(new Date());
        productPrice.setActive(true);

        return save(productPrice);
    }

    @Transactional
    public ProductPrice save(ProductPrice productPrice) {
        return this.repository.save(productPrice);
    }

    public List<ProductPrice> findByProductId(String productId) {
        if (productId == null) {
            throw new IllegalArgumentException("productId is not valid");
        }
        return this.repository.findByProductId(productId);
    }
}
