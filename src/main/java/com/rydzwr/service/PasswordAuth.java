package com.rydzwr.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class PasswordAuth
{
    public static PasswordAuth instance;

    public String passwordFromAuthHeader(String authHeader)
    {
        String deviceCodeBase64 = authHeader.split(" ")[1];
        byte[] decodedBytes = Base64.getDecoder().decode(deviceCodeBase64);

        String password = "";

        password = new String(decodedBytes, StandardCharsets.US_ASCII);

        return password;
    }

    public static PasswordAuth getInstance()
    {
        if (instance == null)
            instance = new PasswordAuth();

        return instance;
    }
}
