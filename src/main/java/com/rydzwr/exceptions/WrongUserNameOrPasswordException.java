package com.rydzwr.exceptions;

public class WrongUserNameOrPasswordException extends RuntimeException
{
    public WrongUserNameOrPasswordException(String message)
    {
        super(message);
    }

    public WrongUserNameOrPasswordException(Throwable cause)
    {
        super(cause);
    }
}
