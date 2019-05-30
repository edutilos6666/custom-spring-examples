package com.example.restbackend.payload;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */
@Data
@RequiredArgsConstructor
public class UserProfile {
    private final Long id;
    private final String name;
    private final String username;
    private final Instant joinedAt;
}
