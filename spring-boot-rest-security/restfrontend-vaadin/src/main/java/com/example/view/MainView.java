package com.example.view;

import com.example.utils.ApiClient;
import com.example.utils.ViewSwitcher;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * created by  Nijat Aghayev on 31.05.19
 */


@Slf4j
@Route("")
@StyleSheet("frontend://styles/styles.css")
@SpringComponent
public class MainView extends VerticalLayout {
    @Autowired
    private LoginView loginView;
    @PostConstruct
    public void init() {
       add(loginView);
    }
}

