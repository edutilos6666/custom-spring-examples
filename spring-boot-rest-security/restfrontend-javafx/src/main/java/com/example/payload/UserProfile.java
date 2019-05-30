package com.example.payload;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */
@Data
@NoArgsConstructor
public class UserProfile {
    private Long id;
    private String name;
    private String username;
    private Instant joinedAt;

    public UserProfile(Long id, String name, String username, Instant joinedAt) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.joinedAt = joinedAt;
    }
}
