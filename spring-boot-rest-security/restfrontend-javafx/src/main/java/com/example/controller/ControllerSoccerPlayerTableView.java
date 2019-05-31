package com.example.controller;

import com.example.payload.SoccerPlayerResponse;
import com.example.utils.ApiClient;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * created by  Nijat Aghayev on 31.05.19
 */
@Slf4j
@Controller
public class ControllerSoccerPlayerTableView {
    @FXML
    private Button btnFirst, btnPrev, btnNext, btnLast;
    @FXML
    private Label lblPage, lblElements;
    @FXML
    private TableView<SoccerPlayerResponse> tvSoccerPlayers;
    @FXML
    private TableColumn<SoccerPlayerResponse, String> colName;
    @FXML
    private TableColumn<SoccerPlayerResponse, Integer> colAge;
    @FXML
    private TableColumn<SoccerPlayerResponse, Double> colWage;
    @FXML
    private TableColumn<SoccerPlayerResponse, String> colCountry;
    @FXML
    private TableColumn<SoccerPlayerResponse, String> colTeam;
    @Autowired
    private ApiClient apiClient;

    private IntegerProperty pageNumber = new SimpleIntegerProperty(0);
    private LongProperty totalCount = new SimpleLongProperty();
    private IntegerProperty totalPageCount = new SimpleIntegerProperty();
    @FXML
    private void initialize() {
        initComponents();
        registerBindings();
        registerEvents();
    }

    private void initComponents() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colWage.setCellValueFactory(new PropertyValueFactory<>("wage"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        colTeam.setCellValueFactory(new PropertyValueFactory<>("team"));

        totalCount.set(apiClient.getTotalSoccerPlayersCount());
        totalPageCount.set(apiClient.getTotalSoccerPlayersPageCount());

        refreshTableView();
    }

    private void registerBindings() {
        btnFirst.disableProperty().bind(pageNumber.isEqualTo(0));
        btnPrev.disableProperty().bind(pageNumber.isEqualTo(0));

        btnNext.disableProperty().bind(pageNumber.isEqualTo(totalPageCount.subtract(1)));
        btnLast.disableProperty().bind(pageNumber.isEqualTo(totalPageCount.subtract(1)));
    }

    private void registerEvents() {
        btnFirst.setOnAction(evt-> {
            pageNumber.set(0);
            refreshTableView();
        });

        btnPrev.setOnAction(evt-> {
            pageNumber.set(pageNumber.get() - 1);
            refreshTableView();
        });

        btnNext.setOnAction(evt-> {
            pageNumber.set(pageNumber.get() + 1);
            refreshTableView();
        });

        btnLast.setOnAction(evt-> {
            pageNumber.set(totalPageCount.get() - 1);
            refreshTableView();
        });
    }

    private void refreshTableView() {
        tvSoccerPlayers.getItems().clear();
        tvSoccerPlayers.getItems().addAll(apiClient.findPlayersByPage(pageNumber.get()));
    }
}
