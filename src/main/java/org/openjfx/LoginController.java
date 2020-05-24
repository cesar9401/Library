/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.openjfx.DAO.AdministradorDAO;
import org.openjfx.DTO.Administrador;

/**
 * FXML Controller class
 *
 * @author cesar31
 */
public class LoginController implements Initializable {

    @FXML
    private Button buttonLogIn;
    @FXML
    private Label labelUser;
    @FXML
    private JFXTextField textUser;
    @FXML
    private Label labelPass;
    @FXML
    private JFXPasswordField PassUser;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ActionLogIn(ActionEvent event) {
        String user = textUser.getText();
        String pass = PassUser.getText();
        
        if(!user.equals("") && !pass.equals("")){
            iniciarSesion(user, pass);
        }else{
            System.out.println("Alerta");
        }
    }
    
    private void iniciarSesion(String user, String pass){
        AdministradorDAO adminDAO = new AdministradorDAO();
        Administrador admin = adminDAO.getAdmin(user, pass);
        if(admin != null){
            System.out.println(admin);
        }else{
            System.out.println("Datos Incorrectos");
        }
    }
    
}
