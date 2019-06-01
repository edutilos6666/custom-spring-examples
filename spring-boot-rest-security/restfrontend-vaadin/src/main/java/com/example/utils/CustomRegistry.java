package com.example.utils;

import com.example.payload.UserProfile;

/**
 * created by  Nijat Aghayev on 31.05.19
 */
public class CustomRegistry {
    private static String accessToken; //JWT ACCESS_TOKEN (Authorization Bearer: <ACCESS_TOKEN>)
    private static UserProfile currentUserProfile;
    public static String getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(String accessToken) {
        CustomRegistry.accessToken = accessToken;
    }

    public static UserProfile getCurrentUserProfile() {
        return currentUserProfile;
    }

    public static void setCurrentUserProfile(UserProfile currentUserProfile) {
        CustomRegistry.currentUserProfile = currentUserProfile;
    }
}
