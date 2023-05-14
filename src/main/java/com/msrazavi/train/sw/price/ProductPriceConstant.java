package com.msrazavi.train.sw.price;

import com.msrazavi.train.sw.base.BaseConstant;

/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 */
public final class ProductPriceConstant extends BaseConstant {

    //column
    public static final String TABLE_NAME = "PRODUCT_PRICE";
    public static final String PRODUCT = "PRODUCT_ID";
    public static final String PRICE = "PRICE";
    public static final String ACTIVE = "ACTIVE";
    public static final String PRICE_DATE = "PRICE_DATE";
    public static final String ACTIVE_UK = UNIQUE_KEY_PREFIX + ACTIVE + KEY_DELIMITER + PRICE;
    public static final String PRODUCT_FK = FOREIGN_KEY_PREFIX + PRODUCT;

    private ProductPriceConstant() {
    }
}
