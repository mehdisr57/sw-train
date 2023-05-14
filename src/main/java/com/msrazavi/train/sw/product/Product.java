package com.msrazavi.train.sw.product;

import com.msrazavi.train.sw.base.BaseEntity;
import jakarta.persistence.Entity;

@Entity
public class Product extends BaseEntity {

    private String name;

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
