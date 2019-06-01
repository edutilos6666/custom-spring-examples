package com.example.view.components;

import com.example.payload.UserProfile;
import com.example.utils.Constants;
import com.example.utils.CustomRegistry;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;

import javax.annotation.PostConstruct;

/**
 * Created by Nijat Aghayev on 01.06.19.
 */
@SpringComponent
public class UserDetailsTabContent extends VerticalLayout {
    private TextField fieldName;
    private TextField fieldUsername;
    private TextField fieldJoinedAt;

    @PostConstruct
    public void init() {
        initComponents();
    }
    private void initComponents() {
        fieldName = new TextField("Name");
        fieldUsername = new TextField("Username");
        fieldJoinedAt = new TextField("Joined At");

        fieldName.setReadOnly(true);
        fieldUsername.setReadOnly(true);
        fieldJoinedAt.setReadOnly(true);

        add(fieldName, fieldUsername, fieldJoinedAt);
    }
    public void fill() {
        UserProfile userProfile = CustomRegistry.getCurrentUserProfile();
        fieldName.setValue(userProfile.getName());
        fieldUsername.setValue(userProfile.getUsername());
        fieldJoinedAt.setValue(Constants.DATE_TIME_FORMATTER.format(userProfile.getJoinedAt()));
    }
}
