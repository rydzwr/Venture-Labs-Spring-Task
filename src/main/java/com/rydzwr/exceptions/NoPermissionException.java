package com.rydzwr.exceptions;

public class NoPermissionException extends RuntimeException
{
    public NoPermissionException(String message)
    {
        super(message);
    }

    public NoPermissionException(Throwable cause)
    {
        super(cause);
    }
}
