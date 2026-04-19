package org.example.Exceptions;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> BusinessError(BusinessException e){
        Map<String,String> response=new LinkedHashMap<>();
        response.put(e.getStatus().toString(),e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(response);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> ValidError(MethodArgumentNotValidException e){
        Map<String,Object> response=new LinkedHashMap<>();
        response.put("errors",e.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage)));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new ErrorResponse("400",response));
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> ExceptionError(Exception e){
        Map<String,String> response=new LinkedHashMap<>();
        response.put("500",e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
