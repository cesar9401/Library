/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
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
    @FXML
    private ImageView imageLogin;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        iniitializeElements();
    }  
    
    private void iniitializeElements() {
        Image image = new Image("org/openjfx/image/library.jpg");
        imageLogin.setImage(image);
        
        //iniciar Sesion por test
        iniciarSesionAuto();
    }    
    

    @FXML
    private void ActionLogIn(ActionEvent event) {
        String user = textUser.getText();
        String pass = PassUser.getText();
        
        if(!user.equals("") && !pass.equals("")){
            try {
                iniciarSesion(user, pass);
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }else{
            System.out.println("Alerta");
        }
    }
    
    private void iniciarSesion(String user, String pass) throws IOException{
        AdministradorDAO adminDAO = new AdministradorDAO();
        Administrador admin = adminDAO.getAdmin(user, pass);
        if(admin != null){
            this.textUser.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainView.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Library");
            stage.setScene(scene);
            stage.show();
        }else{
            System.out.println("Datos Incorrectos");
        }
    }
    
    private void iniciarSesionAuto(){
        textUser.setText("cesar31");
        PassUser.setText("123");
    }
}
