package com.ashuraDev.TaskNest.Application.Exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
