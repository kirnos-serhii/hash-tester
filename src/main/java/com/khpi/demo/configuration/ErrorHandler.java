package com.khpi.demo.configuration;

import com.khpi.demo.exception.HashAlgorithmTesterRuntimeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(HashAlgorithmTesterRuntimeException.class)
    public ResponseEntity<List<String>> noRecipientsException(HashAlgorithmTesterRuntimeException exception) {
        return ResponseEntity.badRequest().body(Collections.singletonList(exception.getMessage()));
    }

//    @ExceptionHandler(Throwable.class)
//    public ResponseEntity<List<String>> throwable(Throwable exception) {
//        System.out.println(exception.getMessage());
//        return ResponseEntity.badRequest().body(Collections.singletonList(exception.getMessage()));
//    }
}
