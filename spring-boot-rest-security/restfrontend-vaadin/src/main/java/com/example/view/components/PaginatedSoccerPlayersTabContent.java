package com.example.view.components;

import com.example.payload.SoccerPlayerResponse;
import com.example.utils.ApiClient;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Nijat Aghayev on 01.06.19.
 */
@SpringComponent
public class PaginatedSoccerPlayersTabContent extends VerticalLayout {
    private HorizontalLayout horizontalLayoutSpans;
    private Span spanTotalCount, spanPageIndex;
    private HorizontalLayout horizontalLayoutButtons;
    private Button btnFirst, btnPrev, btnNext, btnLast;
    private Grid<SoccerPlayerResponse> gridSoccerPlayers;
    @Autowired
    private ApiClient apiClient;
    private Long totalCount;
    private int totalPageCount, pageIndex;

    @PostConstruct
    public void init() {
        initComponents();
        addStyles();
        registerEvents();
    }

    private void initComponents() {
        horizontalLayoutSpans = new HorizontalLayout();
        spanTotalCount = new Span();
        spanPageIndex = new Span();
        horizontalLayoutSpans.add(spanTotalCount, spanPageIndex);
        horizontalLayoutButtons = new HorizontalLayout();
        btnFirst = new Button("<<");
        btnPrev = new Button("<");
        btnNext = new Button(">");
        btnLast = new Button(">>");
        horizontalLayoutButtons.add(btnFirst, btnPrev, btnNext, btnLast);
        gridSoccerPlayers = new Grid<>(SoccerPlayerResponse.class);
        add(horizontalLayoutSpans, horizontalLayoutButtons, gridSoccerPlayers);
    }
    private void addStyles() {

    }
    private void registerEvents() {
        btnFirst.addClickListener(evt-> {
           pageIndex = 0;
           List<SoccerPlayerResponse> players = apiClient.findPlayersByPage(pageIndex);
           gridSoccerPlayers.setItems(players);
           btnFirst.setEnabled(false);
           btnPrev.setEnabled(false);
           if(!players.isEmpty()) {
               btnNext.setEnabled(true);
               btnLast.setEnabled(true);
           }
           fillSpans();
        });

        btnPrev.addClickListener(evt-> {
           pageIndex -= 1;
            List<SoccerPlayerResponse> players = apiClient.findPlayersByPage(pageIndex);
            gridSoccerPlayers.setItems(players);
            if(pageIndex == 0) {
                btnFirst.setEnabled(false);
                btnPrev.setEnabled(false);
            }
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
            fillSpans();
        });

        btnNext.addClickListener(evt-> {
            pageIndex += 1;
            gridSoccerPlayers.setItems(apiClient.findPlayersByPage(pageIndex));
            if(pageIndex == totalPageCount - 1) {
                btnNext.setEnabled(false);
                btnLast.setEnabled(false);
            }
            btnPrev.setEnabled(true);
            btnFirst.setEnabled(true);
            fillSpans();
        });

        btnLast.addClickListener(evt-> {
           pageIndex = totalPageCount - 1;
           gridSoccerPlayers.setItems(apiClient.findPlayersByPage(pageIndex));
            btnNext.setEnabled(false);
            btnLast.setEnabled(false);
            btnPrev.setEnabled(true);
            btnFirst.setEnabled(true);
            fillSpans();
        });
    }

    public void fill() {
        totalCount = apiClient.getTotalSoccerPlayersCount();
        totalPageCount = apiClient.getTotalSoccerPlayersPageCount();
        List<SoccerPlayerResponse> players = apiClient.findPlayersByPage(pageIndex);
        gridSoccerPlayers.setItems(players);
        gridSoccerPlayers.setColumns("name", "age", "wage", "country", "team");
        if(!players.isEmpty()) {
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
        }
        btnPrev.setEnabled(false);
        btnFirst.setEnabled(false);
        spanTotalCount.setText(String.format("Total Count = %d", totalCount));
        fillSpans();
    }

    private void fillSpans() {
        spanPageIndex.setText(String.format("Page %d of %d", (pageIndex+1), totalPageCount));
    }
}
