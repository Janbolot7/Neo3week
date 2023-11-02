package com.example.Neo3week.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String exceptionMessage){
        super(exceptionMessage);
    }
}
