package com.example.utils;

import javafx.stage.Stage;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */
public class Constants {
    public static final String WINDOW_SIGNUP_LOC = "/fxml/WindowSignup.fxml";
    public static final String WINDOW_LOGIN_LOC = "/fxml/WindowLogin.fxml";
    public static final String WINDOW_USER_HOME_LOC = "/fxml/WindowUserHome.fxml";
    public static final String WINDOW_SOCCER_PLAYER_TITLED_PANE = "/fxml/WindowSoccerPlayerTitledPane.fxml";
    public static final String WINDOW_SOCCER_PLAYER_TABLE_VIEW = "/fxml/WindowSoccerPlayerTableView.fxml";

    public static final String STAGE_SIGNUP_NAME = "STAGE_SIGNUP";
    public static final String STAGE_LOGIN_NAME = "STAGE_LOGIN";

    public static final Stage STAGE_LOGIN = new Stage();


    public static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            .withZone(ZoneId.systemDefault());

    public static final Integer SOCCER_PLAYERS_PAGE_SIZE = 10;
}
