package com.msrazavi.train.sw.price;

import com.msrazavi.train.sw.product.Product;
import com.msrazavi.train.sw.product.ProductController;
import com.msrazavi.train.sw.tools.SecurityTestTools;
import com.msrazavi.train.sw.util.JsonUtil;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Collections;

/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProductPriceController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
class ProductPriceControllerTest {

    @MockBean
    private ProductPriceService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPricesOfProductTest() throws Exception {
        Mockito.when(service.findByProductId("1")).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get(ProductController.URL + "/1/price")
                        .header("Authorization", SecurityTestTools.AUTH_HEADER)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("*", Matchers.empty()));
    }

    @Test
    void setPriceTest() throws Exception {
        ProductPrice request = createProductPrice();
        ProductPrice result = createProductPrice();
        result.setId("resultId");

        Mockito.when(service.setPrice(request)).thenReturn(result);

        mockMvc.perform(MockMvcRequestBuilders.post(ProductController.URL + "/price")
                        .content(JsonUtil.asJsonString(request))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("Authorization", SecurityTestTools.AUTH_HEADER)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.notNullValue()));
    }

    private static ProductPrice createProductPrice() {
        final Product product = new Product();
        product.setId("#1");
        ProductPrice productPrice = new ProductPrice();
        productPrice.setProduct(product);
        productPrice.setPrice(BigDecimal.TEN);
        return productPrice;
    }
}
