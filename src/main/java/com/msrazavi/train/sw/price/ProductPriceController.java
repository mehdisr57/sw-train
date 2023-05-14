package com.msrazavi.train.sw.price;

import com.msrazavi.train.sw.base.BaseController;
import com.msrazavi.train.sw.product.ProductController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 * Task 1.4 (RestFull)
 */
@RestController
@RequestMapping(ProductController.URL)
public class ProductPriceController extends BaseController {
    private final ProductPriceService service;

    public ProductPriceController(ProductPriceService service) {
        this.service = service;
    }

    @GetMapping("/{productId}/price")
    public ResponseEntity<List<ProductPrice>> getPricesOfProduct(@PathVariable(name = "productId") String productId) {
        return ResponseEntity.ok(this.service.findByProductId(productId));
    }

    @PostMapping("/price")
    public ResponseEntity<ProductPrice> setPrice(@RequestBody ProductPrice productPrice) {
        return ResponseEntity.ok(this.service.setPrice(productPrice));
    }
}
