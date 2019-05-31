package com.example.utils;

import com.example.controller.ControllerSoccerPlayerTitledPane;
import com.example.payload.SoccerPlayerResponse;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Nijat Aghayev on 31.05.19.
 */
@Slf4j
@Component
public class CustomComponentLoader {
    public TitledPane loadWindowSoccerPlayerTitledPane(SoccerPlayerResponse soccerPlayerResponse) {
        FXMLLoader loader = new FXMLLoader(CustomComponentLoader.class.getResource(Constants.WINDOW_SOCCER_PLAYER_TITLED_PANE));
        try {
            TitledPane root = loader.load();
            root.setText(soccerPlayerResponse.getName());
            ControllerSoccerPlayerTitledPane controller = loader.getController();
            controller.setData(soccerPlayerResponse);
            return root;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public AnchorPane loadWindowSoccerPlayerTableView() {
        FXMLLoader loader = CustomRegistry.getFxmlLoader();
        loader.setLocation(CustomComponentLoader.class.getResource(Constants.WINDOW_SOCCER_PLAYER_TABLE_VIEW));
        try {
            AnchorPane root = loader.load();
            return root;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
