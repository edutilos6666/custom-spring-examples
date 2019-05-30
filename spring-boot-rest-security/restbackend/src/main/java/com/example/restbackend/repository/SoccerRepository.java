package com.example.restbackend.repository;

import com.example.restbackend.model.SoccerPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */
@Repository
public interface SoccerRepository extends JpaRepository<SoccerPlayer, Long> {
    List<SoccerPlayer> findAll();
}
