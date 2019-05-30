package com.example.restbackend.payload;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */
@Data
@RequiredArgsConstructor
public class UserSummary {
    private final Long id;
    private final String username;
    private final String name;
}
