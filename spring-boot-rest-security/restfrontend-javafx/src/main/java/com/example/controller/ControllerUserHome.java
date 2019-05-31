package com.example.controller;

import com.example.payload.SoccerPlayerResponse;
import com.example.payload.UserProfile;
import com.example.utils.ApplicationLauncher;
import com.example.utils.Constants;
import com.example.utils.CustomComponentLoader;
import com.example.utils.CustomRegistry;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */
@Slf4j
@Controller
public class ControllerUserHome {
    @FXML
    private Hyperlink linkLogout;
    @FXML
    private Label nameValue, usernameValue, joinedAtValue;
    @FXML
    private Accordion accordionPlayers;
    @FXML
    private AnchorPane panePaginatedSoccerPlayers;
    @Autowired
    private CustomComponentLoader customComponentLoader;
    @Autowired
    private ApplicationLauncher applicationLauncher;
    @FXML
    private void initialize() {
        initComponents();
        registerEvents();
    }

    private void initComponents() {
        UserProfile currentUser = CustomRegistry.getCurrentUserProfile();
        if(currentUser != null) {
            nameValue.setText(currentUser.getName());
            usernameValue.setText(currentUser.getUsername());
            joinedAtValue.setText(Constants.DATE_TIME_FORMATTER.format(currentUser.getJoinedAt()));
        }

        panePaginatedSoccerPlayers.getChildren().clear();
        panePaginatedSoccerPlayers.getChildren().addAll(customComponentLoader.loadWindowSoccerPlayerTableView().getChildren());
    }

    private void registerEvents() {
        linkLogout.setOnAction(evt-> {
            CustomRegistry.setAccessToken(null);
            CustomRegistry.setCurrentUserProfile(null);
            applicationLauncher.switchToLoginPage();
        });
    }

    public void setData(List<SoccerPlayerResponse> soccerPlayers) {
        for(SoccerPlayerResponse soccerPlayer: soccerPlayers) {
            accordionPlayers.getPanes().add(
                    customComponentLoader.loadWindowSoccerPlayerTitledPane(soccerPlayer));
        }
    }
}
