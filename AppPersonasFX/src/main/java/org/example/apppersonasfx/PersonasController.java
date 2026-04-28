package org.example.apppersonasfx;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.apppersonasfx.model.Persona;
import org.example.apppersonasfx.model.SQLAccessPersona;

import java.net.URL;
import java.util.ResourceBundle;


public class PersonasController implements Initializable {
    private Persona pp;
    private ObservableList<Persona> personas = FXCollections.observableArrayList();
    private String [] estadosLabel= {"se ha creado el registro correctamente", "Error al cerrar el registro",
    "Error al crear el registro",
    "Se ha producido una excepcion"};

    @FXML
    private AnchorPane mainView;

    @FXML
    private AnchorPane formView;

    //Campos de texto del formulario
    @FXML
    private TextField dniTextF;
    @FXML
    private TextField nombreTextF;
    @FXML
    private TextField apellidosTextF;
    @FXML
    private TextField emailTextF;
    @FXML
    private TextField telefonoTextF;
    @FXML
    private TextField edadTextF;

    @FXML
    private TextField infoLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        //Codigo que queremos o necesitamos que se ejecute al principio
        this.mainView.setVisible(true);
        this.formView.setVisible(false);
        this.clearFieldTexts();

        this.dniTextF.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue) {
                this.dniTextF.setText("");
                this.dniTextF. setPromptText("debe ingresar el dni");
            }
        });

    }



    @FXML
    public void onSalirButtonClick(ActionEvent actionEvent) {
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

    public void onGuardarFormClick(ActionEvent actionEvent) {
        try {
            this.pp = Persona.builder()
                    .dni(this.dniTextF.getText())
                    .name(this.nombreTextF.getText())
                    .surname(this.apellidosTextF.getText())
                    .email(this.emailTextF.getText())
                    .age(Integer.parseInt(this.telefonoTextF.getText()))
                    .phone(this.telefonoTextF.getText())
                    .build();
            if (SQLAccessPersona.createPersona(pp)) {
                this.clearFieldTexts();
                this.infoLabel.setVisible(true);
            } else {
                this.infoLabel.setText(this.estadosLabel[1]);
                this.infoLabel.setVisible(true);
            }
        }catch (NumberFormatException e){
            this.edadTextF.setText("");
            this.edadTextF.setPromptText("Escriba un numero");
        }catch(Exception e){
            this.infoLabel.setText(this.estadosLabel[2]);
            this.infoLabel.setVisible(true);
        }

    }

    public void onCancelFormClick(ActionEvent actionEvent) {
        this.formView.setVisible(false);
        this.mainView.setVisible(true);

        this.clearFieldTexts();

    }

    private void clearFieldTexts() {
        this.dniTextF.clear();
        this.nombreTextF.clear();
        this.apellidosTextF.clear();
        this.emailTextF.clear();
        this.telefonoTextF.clear();
        this.edadTextF.clear();


    }

    private boolean validarDni(String dni){
        return dni.matches("[0-9]{7,8}[A-Z a-z]");
    }

    private boolean validarNombre(String nombre){
        return nombre.matches("^[A-Za-z]+$");   
    }

    private boolean validarApellidosText(String apellidos){
        return apellidos.matches("^[A-Za-z]+$");
    }

    private boolean validarEmail(String email){
        String emailPaterrn = "^(?"
    }

    public void onSalirButtonOnAction(ActionEvent actionEvent) {
    }
}