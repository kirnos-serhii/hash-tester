package com.khpi.demo.configuration;

import com.khpi.demo.exception.HashAlgorithmTesterRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;

@Slf4j
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(HashAlgorithmTesterRuntimeException.class)
    public ResponseEntity<List<String>> noRecipientsException(HashAlgorithmTesterRuntimeException exception) {
        log.error("internal_server_error", exception);
        return ResponseEntity.badRequest().body(Collections.singletonList(exception.getMessage()));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<List<String>> throwable(Throwable exception) {
        log.error("internal_server_error", exception);
        System.out.println(exception.getMessage());
        return ResponseEntity.badRequest().body(Collections.singletonList(exception.getMessage()));
    }
}
