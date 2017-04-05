package com.sdajava.javaFX.controller;

import com.sdajava.javaFX.Main;
import com.sdajava.javaFX.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by Andrzej on 04.04.2017.
 */
public class PersonOverviewController {

    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;


    private Main main; //referencja do klasy glownej


    public PersonOverviewController() {

    }
    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(data -> data.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory((data -> data.getValue().lastNameProperty()));
    }

    public void setMain(Main main){
        this.main = main;
        personTable.setItems(main.getPersonData());
    }



}

