package com.edutilos.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Nijat Aghayev on 27.05.19.
 */
public class PasswordEncodeUtil {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("bar"));
        System.out.println(encoder.encode("messi"));
    }
}
