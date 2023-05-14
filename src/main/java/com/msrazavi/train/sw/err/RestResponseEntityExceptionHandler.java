package com.msrazavi.train.sw.err;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ProductIdNotFoundException.class,
            IllegalArgumentException.class,
            IllegalStateException.class})
    public ResponseEntity<ResponseError> handleProductIdNotFoundException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseError(e.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ResponseError> handleError(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
    }
}
