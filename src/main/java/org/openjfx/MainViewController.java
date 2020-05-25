/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cesar31
 */
public class MainViewController implements Initializable {

    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem itemcerrarSesion;
    @FXML
    private JFXButton buttonPrestamo;
    @FXML
    private JFXButton buttonDevolucion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ActionCerrarSesion(ActionEvent event) {
        try {
            cerrarSesion();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void cerrarSesion() throws IOException {
        this.menuBar.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ActionMainView(ActionEvent event) {
        try {
            actionMain(event);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private void actionMain(ActionEvent ev) throws IOException {
        Object obj = ev.getSource();
        
        FXMLLoader loader;
        Parent root;
        Scene scene;
        Stage stage = new Stage();
        if(obj == buttonPrestamo){
            loader = new FXMLLoader(getClass().getResource("view/NuevoPrestamo.fxml"));
            root = loader.load();
            scene = new Scene(root);
            stage.setTitle("Nuevo Prestamo");
        } else{
            loader = new FXMLLoader(getClass().getResource("view/Devolucion.fxml"));
            root = loader.load();
            scene = new Scene(root);
            stage.setTitle("Devolucion");
        }
        stage.setScene(scene);
        stage.showAndWait();
    }

    
    
}
