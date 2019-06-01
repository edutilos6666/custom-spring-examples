package com.example.view;

import com.example.payload.UserProfile;
import com.example.utils.ApiClient;
import com.example.utils.CustomRegistry;
import com.example.view.components.SoccerPlayersTabContent;
import com.example.view.components.UserDetailsTabContent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
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
public class HomeView extends VerticalLayout {
    private Button btnSignout;
    private Tabs tabs;
    private Tab tabUserDetails;
    private Tab tabSoccerPlayers;
    private Tab tabPaginatedSoccerPlayers;
    @Autowired
    private UserDetailsTabContent userDetailsTabContent;
    @Autowired
    private SoccerPlayersTabContent soccerPlayersTabContent;

    @PostConstruct
    public void init() {
        initComponents();
        addStyles();
        registerEvents();
    }

    public void fill() {
        userDetailsTabContent.fill();
        soccerPlayersTabContent.fill();
        tabUserDetails.add(userDetailsTabContent);
        tabSoccerPlayers.add(soccerPlayersTabContent);
    }
    private void initComponents() {
        btnSignout = new Button("Sign Out");
        tabs = new Tabs();
        tabUserDetails = new Tab("User Details");
        tabSoccerPlayers = new Tab("Soccer Players");
        tabPaginatedSoccerPlayers = new Tab("Paginated Soccer Players");
        tabs.add(tabUserDetails, tabSoccerPlayers, tabPaginatedSoccerPlayers);
        add(btnSignout, tabs);
    }



    private void addStyles() {
        addClassName("home-view");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        btnSignout.getElement().getThemeList().add("danger");
        tabs.setWidth("100%");
        tabUserDetails.setFlexGrow(1);
        tabSoccerPlayers.setFlexGrow(1);
        tabPaginatedSoccerPlayers.setFlexGrow(1);
    }

    private void registerEvents() {

    }
}
