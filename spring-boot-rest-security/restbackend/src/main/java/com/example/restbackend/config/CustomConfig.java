package com.example.restbackend.config;

import com.example.restbackend.model.SoccerPlayer;
import com.example.restbackend.repository.SoccerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */
@Configuration
public class CustomConfig {
    @Autowired
    private SoccerRepository soccerRepository;

    @Bean
    CommandLineRunner populate() {
        return strings -> soccerRepository.saveAll(Arrays.asList(
                new SoccerPlayer("messi", 30, 3000.0, "Argentina", "Barcelona"),
                new SoccerPlayer("ronaldo", 32, 3200.0, "Portugal", "Juventus"),
                new SoccerPlayer("Ibrahimovic", 35, 3500.0, "Sweden", "Galaxy")
        ));
    }
}
