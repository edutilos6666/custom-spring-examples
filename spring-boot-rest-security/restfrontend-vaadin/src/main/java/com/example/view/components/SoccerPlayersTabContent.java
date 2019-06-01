package com.example.view.components;

import com.example.payload.SoccerPlayerResponse;
import com.example.utils.ApiClient;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Nijat Aghayev on 01.06.19.
 */
@SpringComponent
public class SoccerPlayersTabContent extends VerticalLayout {
    private Grid<SoccerPlayerResponse> grid;
    @Autowired
    private ApiClient apiClient;

    @PostConstruct
    public void init() {
        initComponents();
    }

    private void initComponents() {
        grid = new Grid<>(SoccerPlayerResponse.class);
        add(grid);
    }

    public void fill() {
        List<SoccerPlayerResponse> soccerPlayers = apiClient.findFirst10Players();
        grid.setItems(soccerPlayers);
        grid.setColumns("name", "age", "wage", "country", "team");
    }
}
