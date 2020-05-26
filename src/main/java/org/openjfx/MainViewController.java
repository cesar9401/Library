/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.openjfx.DAO.PrestamoDAO;
import org.openjfx.DTO.Prestamo;

/**
 * FXML Controller class
 *
 * @author cesar31
 */
public class MainViewController implements Initializable {

    private ObservableList<Prestamo> prestamos;
    
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem itemcerrarSesion;
    @FXML
    private JFXButton buttonPrestamo;
    @FXML
    private JFXButton buttonDevolucion;
    @FXML
    private TableView<Prestamo> tablePrestamos;
    @FXML
    private TableColumn columnNumero;
    @FXML
    private TableColumn columnEstudiante;
    @FXML
    private TableColumn columnLibro;
    @FXML
    private TableColumn columnFecha;
    @FXML
    private Label labelPrestamos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        createTable();
        setTable();
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

    private void createTable() {
        prestamos = FXCollections.observableArrayList();
        this.columnEstudiante.setCellValueFactory(new PropertyValueFactory("carnetEstudiante"));
        this.columnNumero.setCellValueFactory(new PropertyValueFactory("id_prestamo"));
        this.columnLibro.setCellValueFactory(new PropertyValueFactory("nombreLibro"));
        this.columnFecha.setCellValueFactory(new PropertyValueFactory("fechaString"));
    }

    private void setTable() {
        prestamos.clear();
        PrestamoDAO getPrestamos = new PrestamoDAO();
        List<Prestamo> prest = getPrestamos.getPrestamosActivos();
        if(!this.prestamos.containsAll(prest)){
            this.prestamos.addAll(prest);
            tablePrestamos.setItems(prestamos);
        }
    }

    
    
}
