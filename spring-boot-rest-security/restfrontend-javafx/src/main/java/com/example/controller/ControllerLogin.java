package com.example.controller;

import com.example.payload.JwtAuthenticationResponse;
import com.example.payload.LoginRequest;
import com.example.payload.UserProfile;
import com.example.utils.ApiClient;
import com.example.utils.ApplicationLauncher;
import com.example.utils.CustomRegistry;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */
@Slf4j
@Controller
public class ControllerLogin {
    @FXML
    private Hyperlink linkSignup;
    @FXML
    private TextField fieldUsername;
    @FXML
    private PasswordField fieldPassword;
    @FXML
    private Label lblUsernameError, lblPasswordError;
    @FXML
    private Button btnLogin, btnClear;
    @Autowired
    private ApiClient apiClient;
    @Autowired
    private ApplicationLauncher applicationLauncher;
    @FXML
    private void initialize() {
        initComponents();
        registerBindings();
        registerEvents();
//        RestTemplate restTemplate = Registry.getApplicationContext().getBean(RestTemplate.class);
//        log.info(restTemplate.toString());
        log.info(apiClient.toString());
        apiClient.displayRestTemplate();
    }

    private void initComponents() {
        lblUsernameError.setVisible(false);
        lblPasswordError.setVisible(false);
        btnLogin.setDisable(true);
    }

    private void registerBindings() {
        btnLogin.disableProperty().bind(lblUsernameError.visibleProperty()
        .or(lblPasswordError.visibleProperty()));
        btnClear.disableProperty().bind(fieldUsername.textProperty().isEmpty()
                .and(fieldPassword.textProperty().isEmpty()));
    }

    private void registerEvents() {
        fieldUsername.setOnKeyReleased(evt-> {
            lblUsernameError.setVisible(fieldUsername.getText().isEmpty());
        });

        fieldPassword.setOnKeyReleased(evt-> {
            lblPasswordError.setVisible(fieldPassword.getText().isEmpty());
        });

        linkSignup.setOnAction(evt-> {
            applicationLauncher.switchToSignupPage();
        });

        btnLogin.setOnAction(evt-> {
            try {
                JwtAuthenticationResponse response = apiClient.loginAction(new LoginRequest(fieldUsername.getText().trim(),
                        fieldPassword.getText().trim()));
                log.info(response.getAccessToken());
                CustomRegistry.setAccessToken(response.getAccessToken());
                UserProfile user = apiClient.findUserByUsername(fieldUsername.getText().trim());
                CustomRegistry.setCurrentUserProfile(user);
                applicationLauncher.switchToUserHome();
            } catch(Exception ex) {
                log.error(ex.getMessage());
            }
        });
    }
}
