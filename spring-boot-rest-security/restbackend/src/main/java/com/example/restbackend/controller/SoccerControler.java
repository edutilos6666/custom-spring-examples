package com.example.restbackend.controller;

import com.example.restbackend.model.SoccerPlayer;
import com.example.restbackend.repository.SoccerRepository;
import com.example.restbackend.security.CurrentUser;
import com.example.restbackend.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */
@RestController
@RequestMapping("/api/soccer")
public class SoccerControler {
    @Autowired
    private SoccerRepository soccerRepository;
    @RequestMapping("/players")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<SoccerPlayer>> getAllPlayers(
            @CurrentUser UserPrincipal currentUser) {
        return ResponseEntity.ok().body(soccerRepository.findAll());
    }
}
