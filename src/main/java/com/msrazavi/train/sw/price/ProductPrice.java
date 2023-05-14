package com.msrazavi.train.sw.price;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.msrazavi.train.sw.base.BaseConstant;
import com.msrazavi.train.sw.base.BaseEntity;
import com.msrazavi.train.sw.product.Product;
import com.msrazavi.train.sw.util.LazyFieldsFilter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 */
@Entity
@Table(name = ProductPriceConstant.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = ProductPriceConstant.ACTIVE_UK,
                columnNames = {ProductPriceConstant.PRODUCT, ProductPriceConstant.ACTIVE})
})
public class ProductPrice extends BaseEntity {

    @Column(name = ProductPriceConstant.PRICE)
    private BigDecimal price;

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = LazyFieldsFilter.class)
    @JoinColumn(name = ProductPriceConstant.PRODUCT,
            referencedColumnName = BaseConstant.ID,
            foreignKey = @ForeignKey(name = ProductPriceConstant.PRODUCT_FK)
    )
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @Column(name = ProductPriceConstant.PRICE_DATE)
    private Date priceDate;
    @Column(name = ProductPriceConstant.ACTIVE)
    private Boolean active;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(Date date) {
        this.priceDate = date;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
