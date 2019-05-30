package com.example.controller;

import com.example.payload.ApiResponse;
import com.example.payload.SignUpRequest;
import com.example.utils.ApiClient;
import com.example.utils.ApplicationLauncher;
import com.example.utils.Constants;
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
public class ControllerSignup {
    @FXML
    private Hyperlink linkLogin;
    @FXML
    private TextField fieldName, fieldUsername, fieldEmail;
    @FXML
    private PasswordField fieldPassword;
    @FXML
    private Label lblNameError, lblUsernameError, lblEmailError, lblPasswordError;
    @FXML
    private Button btnSignup, btnClear;
    @Autowired
    private ApiClient apiClient;
    @Autowired
    private ApplicationLauncher applicationLauncher;
    @FXML
    private void initialize() {
        initComponents();
        registerBindings();
        registerEvents();
    }

    private void initComponents() {
        lblNameError.setVisible(false);
        lblUsernameError.setVisible(false);
        lblEmailError.setVisible(false);
        lblPasswordError.setVisible(false);
        btnSignup.setDisable(true);
    }

    private void registerBindings() {
        btnSignup.disableProperty().bind(
                lblNameError.visibleProperty()
                .or(lblUsernameError.visibleProperty()
                .or(lblEmailError.visibleProperty()
                .or(lblPasswordError.visibleProperty())))
        );

        btnClear.disableProperty().bind(
                fieldName.textProperty().isEmpty()
                .and(fieldUsername.textProperty().isEmpty()
                .and(fieldEmail.textProperty().isEmpty()
                .and(fieldPassword.textProperty().isEmpty())))
        );
    }

    private void registerEvents() {
        fieldName.setOnKeyReleased(evt-> {
            String val = fieldName.getText().trim();
            lblNameError.setVisible(val.length() < 4 || val.length() > 40);
        });

        fieldUsername.setOnKeyReleased(evt-> {
            String val = fieldUsername.getText().trim();
            lblUsernameError.setVisible(val.length() < 3 || val.length() > 15);
        });

        fieldEmail.setOnKeyReleased(evt-> {
            String val = fieldEmail.getText().trim();
            lblEmailError.setVisible(val.length() == 0 || val.length() > 40 || !val.contains("@"));
        });

        fieldPassword.setOnKeyReleased(evt-> {
            String val = fieldPassword.getText().trim();
            lblPasswordError.setVisible(val.length() < 6  || val.length() > 20);
        });


        linkLogin.setOnAction(evt-> {
            applicationLauncher.switchToLoginPage();
        });

        btnSignup.setOnAction(evt-> {
            ApiResponse apiResponse = apiClient.singupAction(new SignUpRequest(
                            fieldName.getText().trim(),
                            fieldUsername.getText().trim(),
                            fieldEmail.getText().trim(),
                            fieldPassword.getText().trim()));
            log.info(apiResponse.getMessage()+ " "+ apiResponse.getSuccess());
            applicationLauncher.switchToLoginPage();
        });

        btnClear.setOnAction(evt-> {
            fieldName.clear();
            fieldUsername.clear();
            fieldEmail.clear();
            fieldPassword.clear();
        });
    }
}
