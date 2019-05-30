package com.example.wrapper;

import com.example.payload.SoccerPlayer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */
@Data
@NoArgsConstructor
public class SoccerPlayerList {
    private List<SoccerPlayer> soccerPlayers;

    public SoccerPlayerList(List<SoccerPlayer> soccerPlayers) {
        this.soccerPlayers = soccerPlayers;
    }
}
