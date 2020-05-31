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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import org.openjfx.DAO.EstudianteDAO;
import org.openjfx.DTO.Estudiante;

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
    private JFXComboBox<String> comboCarreras;
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
        ObservableList<String> carreras = FXCollections.observableArrayList();
        carreras.add("Ingenieria en Ciencias y Sistemas");
        carreras.add("Ingenieria Mecanica");
        carreras.add("Ingenieria Mecanica Industrial");
        carreras.add("Ingenieria Civil");
        carreras.add("Ingenieria Industrial");
        comboCarreras.setItems(carreras);
    }    
    
    public void initializeElements(String carnet){
        this.carnet = carnet;
        textCarnet.setDisable(true);
        textCarnet.setText(carnet);
    }

    @FXML
    private void ActionEstudiante(ActionEvent event) {
        Object obj = event.getSource();
        
        if(obj == buttonRegistrar){
            String nombres = textNombres.getText();
            String apellidos = textApellidos.getText();
            String dpi = textDPI.getText();
            String carrera = (String) comboCarreras.getSelectionModel().getSelectedItem();
            Boolean socio = radioSocio.isSelected();
            
            if(!nombres.equals("") && !apellidos.equals("") && !carrera.equals("")){
                Estudiante estudiante = new Estudiante(carnet, nombres, apellidos, dpi, carrera, socio);
                EstudianteDAO estudianteDAO = new EstudianteDAO();
                estudianteDAO.insertEstudiante(estudiante);
                
                //Alerta
                
                //Cerrar ventana
                this.buttonRegistrar.getScene().getWindow().hide();
            }else{
                //Alerta
            }
            
        }else if(obj == buttonCancelar){
            buttonCancelar.getScene().getWindow().hide();
        }
    }
    
}
