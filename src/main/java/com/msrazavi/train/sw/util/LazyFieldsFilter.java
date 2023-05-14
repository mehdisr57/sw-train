package com.msrazavi.train.sw.util;

import jakarta.persistence.Persistence;

public class LazyFieldsFilter {

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return !Persistence.getPersistenceUtil().isLoaded(obj);
    }
}
