package com.msrazavi.train.sw.product;

import com.msrazavi.train.sw.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 */

@Entity
public class Product extends BaseEntity {

    @Column(name = ProductConstant.NAME)
    private String name;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
