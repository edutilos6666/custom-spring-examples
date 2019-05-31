package com.example.view;

import com.example.utils.ApiClient;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by  Nijat Aghayev on 31.05.19
 */
@SpringComponent
//@UIScope
public class RegisterView extends VerticalLayout {
    private TextField fieldName, fieldUsername;
    private EmailField fieldEmail;
    private PasswordField fieldPassword;
    private Button btnLogin, btnSignup, btnClear;
    @Autowired
    private ApiClient apiClient;

    public RegisterView() {
        initComponents();
        registerEvents();
    }

    private void initComponents() {
        btnLogin = new Button("Login");
        fieldName = new TextField("Name");
        fieldUsername = new TextField("Username");
        fieldEmail = new EmailField("Email");
        fieldPassword = new PasswordField("Password");
        btnSignup = new Button("Sign Up");
        btnClear = new Button("Clear");
        add(btnLogin, fieldName, fieldUsername, fieldEmail, fieldPassword, new HorizontalLayout(btnSignup, btnClear));
    }

    private void registerEvents() {

    }
}
