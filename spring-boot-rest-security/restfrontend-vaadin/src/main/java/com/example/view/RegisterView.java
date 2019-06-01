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
    private Button btnLogin;
    private TextField fieldName, fieldUsername;
    private EmailField fieldEmail;
    private PasswordField fieldPassword;
    private HorizontalLayout horizontalLayout;
    private Button btnSignup, btnClear;
    @Autowired
    private ApiClient apiClient;

    public RegisterView() {
        initComponents();
        addStyles();
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
        horizontalLayout = new HorizontalLayout(btnSignup, btnClear);
        add(btnLogin, fieldName, fieldUsername, fieldEmail, fieldPassword, horizontalLayout);
    }

    private void addStyles() {
        addClassName("register-view");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        fieldName.setWidth("100%");
        fieldUsername.setWidth("100%");
        fieldEmail.setWidth("100%");
        fieldPassword.setWidth("100%");
        horizontalLayout.setWidth("100%");
        btnSignup.setWidth("100%");
        btnClear.setWidth("100%");
    }

    private void registerEvents() {

    }
}
