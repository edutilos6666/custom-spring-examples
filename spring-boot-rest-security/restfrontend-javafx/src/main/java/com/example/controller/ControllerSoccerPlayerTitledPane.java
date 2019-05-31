package com.example.controller;

import com.example.payload.SoccerPlayerResponse;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by Nijat Aghayev on 31.05.19.
 */
public class ControllerSoccerPlayerTitledPane {
    @FXML
    private Label nameValue, ageValue, wageValue, countryValue, teamValue;
    public void setData(SoccerPlayerResponse soccerPlayerResponse) {
        nameValue.setText(soccerPlayerResponse.getName());
        ageValue.setText(soccerPlayerResponse.getAge().toString());
        wageValue.setText(soccerPlayerResponse.getWage().toString());
        countryValue.setText(soccerPlayerResponse.getCountry());
        teamValue.setText(soccerPlayerResponse.getTeam());
    }
}
