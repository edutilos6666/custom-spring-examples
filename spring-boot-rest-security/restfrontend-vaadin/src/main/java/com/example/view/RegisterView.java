package com.example.view;

import com.example.payload.ApiResponse;
import com.example.payload.SignUpRequest;
import com.example.utils.ApiClient;
import com.example.utils.ViewSwitcher;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by  Nijat Aghayev on 31.05.19
 */
@Slf4j
@SpringComponent
//@UIScope
public class RegisterView extends VerticalLayout {
    private Button btnLogin;
    private TextField name, username;
    private EmailField email;
    private PasswordField password;
    private HorizontalLayout horizontalLayout;
    private Button btnSignup, btnClear;
    @Autowired
    private ApiClient apiClient;
    @Autowired
    private ViewSwitcher viewSwitcher;

    private SignUpRequest signUpRequest = new SignUpRequest();

    public RegisterView() {
        initComponents();
        addStyles();
        registerEvents();
    }

    private void initComponents() {
        btnLogin = new Button("Login");
        name = new TextField("Name");
        username = new TextField("Username");
        email = new EmailField("Email");
        password = new PasswordField("Password");
        btnSignup = new Button("Sign Up");
        btnClear = new Button("Clear");
        horizontalLayout = new HorizontalLayout(btnSignup, btnClear);
        add(btnLogin, name, username, email, password, horizontalLayout);
    }

    public void clearFields() {
        name.clear();
        username.clear();
        email.clear();
        password.clear();
    }

    private void addStyles() {
        addClassName("register-view");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        name.setWidth("100%");
        username.setWidth("100%");
        email.setWidth("100%");
        password.setWidth("100%");
        horizontalLayout.setWidth("100%");
        btnSignup.setWidth("100%");
        btnClear.setWidth("100%");
    }

    private void registerEvents() {
        Binder<SignUpRequest> binder = new BeanValidationBinder<>(SignUpRequest.class);
        binder.bindInstanceFields(this);
        binder.setBean(signUpRequest);
        btnLogin.addClickListener(evt-> {
            viewSwitcher.switchToLoginView();
        });
        btnSignup.addClickListener(evt-> {
           ApiResponse apiResponse = apiClient.singupAction(signUpRequest);
           log.info(String.format("%s %s", apiResponse.getSuccess(), apiResponse.getMessage()));
           if(apiResponse.getSuccess()) {
               viewSwitcher.switchToLoginView();
           }
        });
        btnClear.addClickListener(evt-> {
            clearFields();
        });
    }
}
