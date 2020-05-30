/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;

/**
 * FXML Controller class
 *
 * @author cesar31
 */
public class NuevoEstudianteController implements Initializable {
    
    String carnet;
    @FXML
    private JFXTextField textCarnet;
    @FXML
    private JFXTextField textNombres;
    @FXML
    private JFXTextField textApellidos;
    @FXML
    private JFXTextField textDPI;
    @FXML
    private RadioButton radioSocio;
    @FXML
    private JFXComboBox<?> comboCarreras;
    @FXML
    private JFXButton buttonRegistrar;
    @FXML
    private JFXButton buttonCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        textCarnet.setDisable(true);
    }    
    
    public void initializeElements(String carnet){
        this.carnet = carnet;
        textCarnet.setText(carnet);
    }

    @FXML
    private void ActionEstudiante(ActionEvent event) {
        Object obj = event.getSource();
        
        if(obj == buttonRegistrar){
            
        }else if(obj == buttonCancelar){
            buttonCancelar.getScene().getWindow().hide();
        }
    }
    
}
