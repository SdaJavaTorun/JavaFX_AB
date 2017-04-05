package com.sdajava.javaFX;

import com.sdajava.javaFX.controller.PersonOverviewController;
import com.sdajava.javaFX.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    public Main () {
        personData.addAll(new Person("And", "Ty")); //wrzucamy obiekty klasy person
        personData.addAll(new Person("Sdf", "Be"));
        personData.addAll(new Person("Rty", "Hj"));
        personData.addAll(new Person("WER", "Er"));
        personData.addAll(new Person("Rty", "Nm"));

    }


    public ObservableList<Person> getPersonData() {
        return personData;
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Ksiazka adresowa");

        initRootLayout();
        showPersonOveriew();
    }


    public void initRootLayout() { //zaladowac szablon fxml

        try{
            FXMLLoader fmxlLoader = new FXMLLoader();
            fmxlLoader.setLocation(Main.class.getResource("view/RootLayout.fxml")); //getResorce| najbezpieczniejsze dobranie się do plikow. Zwraca url
            rootLayout = fmxlLoader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showPersonOveriew () {

        try{
            FXMLLoader fmxlLoader = new FXMLLoader();
            fmxlLoader.setLocation(Main.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOveriew = fmxlLoader.load();

            //AnchorPane anchorPane = new AnchorPane(personOveriew);
            rootLayout.setCenter(personOveriew);

            PersonOverviewController controller = fmxlLoader.getController();
            controller.setMain(this);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main (String[] args) {
        launch(args);
    }
}
