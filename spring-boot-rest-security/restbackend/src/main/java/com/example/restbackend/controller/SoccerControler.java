package com.example.restbackend.controller;

import com.example.restbackend.payload.SoccerPlayerResponse;
import com.example.restbackend.repository.SoccerRepository;
import com.example.restbackend.security.CurrentUser;
import com.example.restbackend.security.UserPrincipal;
import com.example.restbackend.util.ModelToPayloadConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public ResponseEntity<List<SoccerPlayerResponse>> getAllPlayers(
            @CurrentUser UserPrincipal currentUser) {
        ResponseEntity<List<SoccerPlayerResponse>> res =  ResponseEntity.ok().body(StreamSupport.stream(soccerRepository.findAll().spliterator(), false)
                                        .map(ModelToPayloadConverter::convertSoccerPlayer)
                                        .collect(Collectors.toList()));
        return res;
    }


    @RequestMapping("/players/{page}/{size}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<SoccerPlayerResponse>> getAllPlayers(
            @CurrentUser UserPrincipal currentUser, @PathVariable  int page, @PathVariable  int size) {
        Pageable pageable = PageRequest.of(page, size);
        ResponseEntity<List<SoccerPlayerResponse>> res =  ResponseEntity.ok().body(soccerRepository.findAll(pageable)
                                                        .stream()
                                                        .map(ModelToPayloadConverter::convertSoccerPlayer)
                                                        .collect(Collectors.toList()));
        return res;
    }

    @RequestMapping("/players/totalElementsCount/{size}")
    @PreAuthorize("hasRole('USER')")
    public Long getTotalElements(@CurrentUser UserPrincipal currentUser, @PathVariable int size) {
        return soccerRepository.findAll(PageRequest.of(0, size)).getTotalElements();
    }

    @RequestMapping("/players/totalPagesCount/{size}")
    @PreAuthorize("hasRole('USER')")
    public Integer getTotalPages(@CurrentUser UserPrincipal currentUser, @PathVariable int size) {
        return soccerRepository.findAll(PageRequest.of(0, size)).getTotalPages();
    }

}
