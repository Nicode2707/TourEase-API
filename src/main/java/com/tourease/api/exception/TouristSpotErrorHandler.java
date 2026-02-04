package com.tourease.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TouristSpotErrorHandler {

    @ExceptionHandler(SpotNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleSpotNotFound(SpotNotFoundException exception)
    {
        ExceptionDetails excDetail  = new ExceptionDetails(LocalDateTime.now(),exception.getMessage(),"TouristSpot not found..!");
        return new ResponseEntity<ExceptionDetails>(excDetail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDetails> handleAllException(Exception exception){

        ExceptionDetails excDetail  = new ExceptionDetails(LocalDateTime.now(),exception.getMessage(),"Execution Problem..!");
        return new ResponseEntity<ExceptionDetails>(excDetail,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
