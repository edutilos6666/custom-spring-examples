package com.example.utils;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */
public class UrlStrings {
    public static final String BASE_URL = "http://localhost:8080/api/";
    public static final String SIGNUP_URL = String.format("%s/auth/signup", BASE_URL);
    public static final String SIGNIN_URL = String.format("%s/auth/signin", BASE_URL);
    public static final String SOCCER_PLAYERS_URL = String.format("%s/soccer/players", BASE_URL);
    public static final String USERS_URL = String.format("%s/users", BASE_URL);
}
