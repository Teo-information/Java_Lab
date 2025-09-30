package dev.group.hexagonal_test.adapter.rest_adapter.exception_handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice()
public class WebExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> responseOnError () {
        Map<String, String> map = new HashMap<>(5);

        map.put("error", "Error pe muchacho");

        return ResponseEntity.internalServerError().body(map);
    }
}
