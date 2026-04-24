package org.example.apppersonasfx;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.PopupWindow;
import org.example.apppersonasfx.model.Persona;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonasController implements Initializable {
    private Persona pp;
    private ObservableList<Persona> personas =  FXCollections.observableArrayList();

    @FXML
    private AnchorPane mainView;

    @FXML
    private AnchorPane formView;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        //Codigo que queremos o necesitamos  que se ejecute al principio
        this.mainView.setVisible(true);
        this.formView.setVisible(false);
    }

    @FXML
    public void onSalirButtonOnAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public void onBuscarButtonClick(ActionEvent actionEvent) {
    }

    @FXML
    public void onListadoButtonClick(ActionEvent actionEvent) {
    }

    @FXML
    public void onInsertButtonClick(ActionEvent actionEvent) {
        this.mainView.setVisible(false);
        this.formView.setVisible(true);
    }
}