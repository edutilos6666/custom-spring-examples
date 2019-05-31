package com.example.view;

import com.example.utils.ApiClient;
import com.example.utils.ViewSwitcher;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by  Nijat Aghayev on 31.05.19
 */


@Slf4j
@Route
public class LoginView extends VerticalLayout {
    private Button btnRegister;
    private TextField fieldUsername;
    private PasswordField fieldPassword;
    private Button btnLogin, btnClear;
    @Autowired
    private ApiClient apiClient;
    @Autowired
    private RegisterView registerView;
    @Autowired
    private ViewSwitcher viewSwitcher;

    public LoginView() {
        initComponents();
        registerEvents();
    }


    private void initComponents() {
        btnRegister = new Button("No Registered? -> Register");
        fieldUsername = new TextField("Username");
        fieldPassword = new PasswordField("Password");
        btnLogin = new Button("Login");
        btnClear = new Button("Clear");
        add(btnRegister);
        add(fieldUsername);
        add(fieldPassword);
        add(new HorizontalLayout(btnLogin, btnClear));
    }

    private void registerEvents() {
        btnRegister.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                log.info("btnRegister was clicked!");
                registerView.setVisible(true);
//                viewSwitcher.showRegisterView();
            }
        });
    }
}

