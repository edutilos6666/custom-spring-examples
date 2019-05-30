package com.example.payload;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */
@Data
@RequiredArgsConstructor
public class UserIdentityAvailability {
    private final Boolean available;
}
