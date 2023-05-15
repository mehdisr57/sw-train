package com.msrazavi.train.sw.price;

import com.msrazavi.train.sw.product.Product;
import com.msrazavi.train.sw.product.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 */
@ExtendWith(MockitoExtension.class)
class ProductPriceServiceTest {

    @InjectMocks
    private ProductPriceService service;

    @Mock
    private ProductPriceRepository repository;

    @Mock
    private ProductRepository productRepository;

    @Test
    void setPriceTest_inputNotNull() {
        Assertions.assertThrows(RuntimeException.class, () -> service.setPrice(null));
    }

    @Test
    void setPriceTest_priceIsNotValid() {
        try {
            service.setPrice(new ProductPrice());
            Assertions.fail();
        } catch (Exception exception) {
            Assertions.assertInstanceOf(RuntimeException.class, exception);
        }
    }

    @Test
    void setPriceTest_productIsNotValid() {
        ProductPrice productPrice = new ProductPrice();
        productPrice.setProduct(new Product("without Id Product"));
        productPrice.setPrice(BigDecimal.TEN);
        try {
            service.setPrice(productPrice);
            Assertions.fail();
        } catch (Exception exception) {
            Assertions.assertInstanceOf(RuntimeException.class, exception);
        }
    }

    @Test
    void setPriceTest_notExistProduct() {
        productRepositoryFindByIdMock();
        ProductPrice productPrice = new ProductPrice();
        final Product product = new Product();
        product.setId("notExistId");
        productPrice.setProduct(product);
        productPrice.setPrice(BigDecimal.TEN);
        try {
            service.setPrice(productPrice);
            Assertions.fail();
        } catch (Exception exception) {
            Assertions.assertInstanceOf(RuntimeException.class, exception);
        }
    }

    private void productRepositoryFindByIdMock() {
        final Product product = new Product("exist Product");
        final String id = "existId";
        product.setId(id);
        Mockito.when(productRepository.findById(id)).then(invocation -> Optional.of(product));
    }
}
