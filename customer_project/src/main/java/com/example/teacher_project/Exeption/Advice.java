package com.example.teacher_project.Exeption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Advice extends RuntimeException{
    @ExceptionHandler(value = Api.class)
    public ResponseEntity Api(Api api){
        String msg=api.getMessage();
        return ResponseEntity.status(400).body(msg);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){
        String msg=e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(msg);
    }
}
