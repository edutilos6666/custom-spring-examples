package com.example.controller;

import com.example.payload.SoccerPlayer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by Nijat Aghayev on 31.05.19.
 */
public class ControllerSoccerPlayerTitledPane {
    @FXML
    private Label nameValue, ageValue, wageValue, countryValue, teamValue;
    public void setData(SoccerPlayer soccerPlayer) {
        nameValue.setText(soccerPlayer.getName());
        ageValue.setText(soccerPlayer.getAge().toString());
        wageValue.setText(soccerPlayer.getWage().toString());
        countryValue.setText(soccerPlayer.getCountry());
        teamValue.setText(soccerPlayer.getTeam());
    }
}
