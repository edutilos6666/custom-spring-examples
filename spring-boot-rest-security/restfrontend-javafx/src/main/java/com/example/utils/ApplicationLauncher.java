package com.example.utils;

import com.example.controller.ControllerUserHome;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.example.utils.CustomRegistry.getFxmlLoader;
import static com.example.utils.CustomRegistry.getPrimaryStage;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */
@Slf4j
@Service
public class ApplicationLauncher {
    @Autowired
    private ApiClient apiClient;

    public static void launchByStageName(String stageName) {
        switch(stageName) {
            case Constants.STAGE_SIGNUP_NAME:
                launchSignupPage();
                break;
            case Constants.STAGE_LOGIN_NAME:
                launchLoginPage();
                break;
            default:
                break;
        }
    }

    private static void launchSignupPage() {
        FXMLLoader fxmlLoader = getFxmlLoader();
        fxmlLoader.setLocation(ApplicationLauncher.class.getResource(Constants.WINDOW_SIGNUP_LOC));
        AnchorPane root = null;
        try {
            root = fxmlLoader.load();
            Scene scene = new Scene(root);
            getPrimaryStage().setScene(scene);
            getPrimaryStage().setResizable(false);
            getPrimaryStage().setTitle("SignUp Page");
            getPrimaryStage().show();
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }


    private static void launchLoginPage() {
        FXMLLoader fxmlLoader = getFxmlLoader();
        fxmlLoader.setLocation(ApplicationLauncher.class.getResource(Constants.WINDOW_LOGIN_LOC));
        AnchorPane root = null;
        try {
            root = fxmlLoader.load();
            Scene scene = new Scene(root);
            //temporary primary stage
            getPrimaryStage().setScene(scene);
            getPrimaryStage().setResizable(false);
            getPrimaryStage().setTitle("Login Page");
            getPrimaryStage().show();
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }



    public void switchToSignupPage() {
        FXMLLoader fxmlLoader = getFxmlLoader();
        fxmlLoader.setLocation(ApplicationLauncher.class.getResource(Constants.WINDOW_SIGNUP_LOC));
        AnchorPane root = null;
        try {
            root = fxmlLoader.load();
            getPrimaryStage().hide();
            getPrimaryStage().setScene(new Scene(root));
            getPrimaryStage().setTitle("SignUp Page");
            getPrimaryStage().show();
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }


    public void switchToLoginPage() {
        FXMLLoader fxmlLoader = getFxmlLoader();
        fxmlLoader.setLocation(ApplicationLauncher.class.getResource(Constants.WINDOW_LOGIN_LOC));
        AnchorPane root = null;
        try {
            root = fxmlLoader.load();
            getPrimaryStage().hide();
            getPrimaryStage().setScene(new Scene(root));
            getPrimaryStage().setTitle("Login Page");
            getPrimaryStage().show();
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void switchToUserHome() {
        FXMLLoader fxmlLoader = getFxmlLoader();
        fxmlLoader.setLocation(ApplicationLauncher.class.getResource(Constants.WINDOW_USER_HOME_LOC));
        AnchorPane root = null;
        try {
            root = fxmlLoader.load();
            ControllerUserHome controller = fxmlLoader.getController();
            controller.setData(apiClient.firdFirst10Players());
            getPrimaryStage().hide();
            getPrimaryStage().setScene(new Scene(root));
            getPrimaryStage().setTitle("UserHome Page");
            getPrimaryStage().show();
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
