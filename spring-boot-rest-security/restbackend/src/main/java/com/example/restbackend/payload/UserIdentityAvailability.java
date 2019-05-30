package com.example.restbackend.payload;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserIdentityAvailability {
    private final Boolean available;
}
