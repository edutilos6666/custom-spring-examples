package com.example.utils;

import javafx.stage.Stage;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */
public class Constants {
    public static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            .withZone(ZoneId.systemDefault());

    public static final Integer SOCCER_PLAYERS_PAGE_SIZE = 10;
}
