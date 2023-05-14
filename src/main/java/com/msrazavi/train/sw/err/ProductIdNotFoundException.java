package com.msrazavi.train.sw.err;

/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 */
public class ProductIdNotFoundException extends RuntimeException {
    public ProductIdNotFoundException() {
        super("productId is not valid");
    }

    public static void throwException() {
        throw new ProductIdNotFoundException();
    }

    public static void checkAndThrowException(Object o) {
        if (o == null) throw new ProductIdNotFoundException();
    }
}
