package com.rydzwr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler
{
    @ExceptionHandler(value = {WrongUserNameOrPasswordException.class})
    public ResponseEntity<Object> handleException(WrongUserNameOrPasswordException e)
    {
        HttpStatus notFound = HttpStatus.NOT_FOUND;

        Exception exception = new Exception(
                e.getMessage(),
                e,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(exception, notFound);
    }

    @ExceptionHandler(value = {UserWithGivenLoginAlreadyExistsException.class})
    public ResponseEntity<Object> handleException(UserWithGivenLoginAlreadyExistsException e)
    {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        Exception exception = new Exception(
                e.getMessage(),
                e,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(exception, badRequest);
    }

    @ExceptionHandler(value = {NoPermissionException.class})
    public ResponseEntity<Object> handleException(NoPermissionException e)
    {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        Exception exception = new Exception(
                e.getMessage(),
                e,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(exception, badRequest);
    }
}
