package com.example.restbackend.util;

import com.example.restbackend.model.SoccerPlayer;
import com.example.restbackend.payload.SoccerPlayerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.stream.Collectors;

/**
 * created by  Nijat Aghayev on 31.05.19
 */
public class ModelToPayloadConverter {
    public static SoccerPlayerResponse convertSoccerPlayer(SoccerPlayer soccerPlayer) {
        return new SoccerPlayerResponse(soccerPlayer.getName(), soccerPlayer.getAge(),
                soccerPlayer.getWage(), soccerPlayer.getCountry(), soccerPlayer.getTeam());
    }

}
