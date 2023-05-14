package com.msrazavi.train.sw.product;

import com.msrazavi.train.sw.base.BaseController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author M_SadatRazavi
 * Task 1.4 (RestFull)
 */
@RestController
@RequestMapping(ProductController.URL)
public class ProductController extends BaseController {
    public static final String URL = BASE_URL + "/product";
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<Product>> getAll(@RequestParam(name = "page", defaultValue = FIRST_PAGE, required = false) Integer page,
                                                @RequestParam(name = "size", defaultValue = PAGE_SIZE, required = false) Integer size) {
        return ResponseEntity.ok(this.service.findAll(PageRequest.of(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable String id) {
        return this.service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product product) {
        return ResponseEntity.ok(this.service.save(product));
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return ResponseEntity.ok(this.service.save(product));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.service.delete(id);
    }
}
