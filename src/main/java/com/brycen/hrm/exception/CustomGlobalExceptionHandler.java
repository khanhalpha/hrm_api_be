package com.brycen.hrm.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
     ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
     return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
     ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
     return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();        
        body.put("code", status.value());
        body.put("message", "");
        //Get all errors
//        List<String> errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(x -> x.getField())
//                .collect(Collectors.toList());
        List<FieldError> list = ex.getBindingResult().getFieldErrors();
        List<FieldErrorDetail> errors = new ArrayList<FieldErrorDetail>();
        
        list.forEach(error -> {
            FieldErrorDetail fieldErrorDetail = new FieldErrorDetail();
            fieldErrorDetail.setFieldName(error.getField());
            fieldErrorDetail.setCode(error.getCodes()[3]);
            errors.add(fieldErrorDetail);
        });

        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);

    }
    
    public String mapCode(String message)
    {
        String code = null;
        switch(message) {
            case "null" :
                code = "01";
        }
        
        return code;
    }
}
