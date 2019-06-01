package com.example.view;

import com.example.payload.JwtAuthenticationResponse;
import com.example.payload.LoginRequest;
import com.example.payload.UserProfile;
import com.example.utils.ApiClient;
import com.example.utils.CustomRegistry;
import com.example.utils.ViewSwitcher;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Nijat Aghayev on 01.06.19.
 */
@Slf4j
@StyleSheet("frontend://styles/styles.css")
@SpringComponent
public class LoginView extends VerticalLayout {
    private Button btnRegister;
    private TextField fieldUsername;
    private PasswordField fieldPassword;
    private HorizontalLayout horizontalLayout;
    private Button btnLogin, btnClear;
    @Autowired
    private ApiClient apiClient;
    @Autowired
    private ViewSwitcher viewSwitcher;

    @PostConstruct
    public void init() {
        initComponents();
        addStyles();
        registerEvents();
    }


    private void initComponents() {
        btnRegister = new Button("Register");
        btnRegister.addClassName("btn-register");
        fieldUsername = new TextField("Username");
        fieldPassword = new PasswordField("Password");
        btnLogin = new Button("Login");
        btnClear = new Button("Clear");
        add(btnRegister);
        add(fieldUsername);
        add(fieldPassword);
        horizontalLayout = new HorizontalLayout(btnLogin, btnClear);
        add(horizontalLayout);
    }

    private void addStyles() {
        addClassName("login-view");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        fieldUsername.setWidth("100%");
        fieldPassword.setWidth("100%");
        horizontalLayout.setWidth("100%");
        btnLogin.setWidth("100%");
        btnClear.setWidth("100%");
    }

    private void registerEvents() {
        btnRegister.addClickListener(evt -> viewSwitcher.switchToRegisterView());
        btnLogin.addClickListener(evt-> {
            try {
                JwtAuthenticationResponse response = apiClient.loginAction(new LoginRequest(fieldUsername.getValue().trim(), fieldPassword.getValue().trim()));
                CustomRegistry.setAccessToken(response.getAccessToken());
                UserProfile currentUser = apiClient.findUserByUsername(fieldUsername.getValue().trim());
                CustomRegistry.setCurrentUserProfile(currentUser);
                viewSwitcher.switchToHomeView();
            } catch(Exception ex) {
                Notification.show(ex.getMessage(), 5000, Notification.Position.TOP_CENTER);
            }
        });
        btnClear.addClickListener(evt-> {
           fieldUsername.clear();
           fieldPassword.clear();
        });

        fieldUsername.addKeyPressListener(evt-> {
            if(evt.getCode().isPresent() && evt.getCode().get().equals(Key.ENTER)) {
                btnLogin.click();
            }
        });

        fieldPassword.addKeyPressListener(evt-> {
           if(evt.getCode().isPresent() && evt.getCode().get().equals(Key.ENTER)) {
               btnLogin.click();
           }
        });
    }
}
