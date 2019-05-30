package com.example.utils;

import com.example.payload.UserProfile;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */
public class CustomRegistry {
    private static ConfigurableApplicationContext applicationContext;
    private static Stage primaryStage;
    private static String accessToken; //JWT ACCESS_TOKEN (Authorization Bearer: <ACCESS_TOKEN>)
    private static UserProfile currentUserProfile;

    public static ConfigurableApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ConfigurableApplicationContext applicationContext) {
        CustomRegistry.applicationContext = applicationContext;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        CustomRegistry.primaryStage = primaryStage;
    }

    public static FXMLLoader getFxmlLoader() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        return fxmlLoader;
    }

    public static String getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(String accessToken) {
        CustomRegistry.accessToken = accessToken;
    }

    public static UserProfile getCurrentUserProfile() {
        return currentUserProfile;
    }

    public static void setCurrentUserProfile(UserProfile currentUserProfile) {
        CustomRegistry.currentUserProfile = currentUserProfile;
    }
}
