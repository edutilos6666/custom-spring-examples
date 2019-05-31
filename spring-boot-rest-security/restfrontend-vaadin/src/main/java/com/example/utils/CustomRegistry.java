package com.example.utils;

/**
 * created by  Nijat Aghayev on 31.05.19
 */
public class CustomRegistry {
    private static String accessToken; //JWT ACCESS_TOKEN (Authorization Bearer: <ACCESS_TOKEN>)

    public static String getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(String accessToken) {
        CustomRegistry.accessToken = accessToken;
    }
}
