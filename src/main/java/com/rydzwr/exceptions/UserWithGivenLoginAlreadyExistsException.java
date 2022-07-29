package com.rydzwr.exceptions;

public class UserWithGivenLoginAlreadyExistsException extends RuntimeException
{
    public UserWithGivenLoginAlreadyExistsException(String message)
    {
        super(message);
    }

    public UserWithGivenLoginAlreadyExistsException(Throwable cause)
    {
        super(cause);
    }
}
