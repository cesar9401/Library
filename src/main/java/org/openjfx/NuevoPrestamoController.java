/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.openjfx.DAO.LibroDAO;
import org.openjfx.DTO.Libro;

/**
 * FXML Controller class
 *
 * @author cesar31
 */
public class NuevoPrestamoController implements Initializable {

    private ObservableList<Libro> libros;
    
    @FXML
    private Label labelCarnet;
    @FXML
    private JFXTextField textCarnet;
    @FXML
    private Label labelLibro;
    @FXML
    private JFXTextField textLibro;
    @FXML
    private TableView<Libro> tableLibro;
    @FXML
    private JFXButton buttonProcesar;
    @FXML
    private JFXButton buttonCancelar;
    @FXML
    private TableColumn columnCodigo;
    @FXML
    private TableColumn columnNombre;
    @FXML
    private TableColumn columnAutor;
    @FXML
    private TableColumn columnEdicion;
    @FXML
    private TableColumn columnStock;

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
    private void ActionPrestamoView(ActionEvent event) {
        ActionPrestamo(event);
    }

    private void ActionPrestamo(ActionEvent ev) {
        Object obj = ev.getSource();
        
        if(obj == buttonProcesar){
            //Acciones para procesar prestamo
            
            
        } else if(obj == buttonCancelar){
            this.buttonCancelar.getScene().getWindow().hide();
        }
    }

    private void createTable() {
        libros = FXCollections.observableArrayList();
        this.columnCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        this.columnNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.columnEdicion.setCellValueFactory(new PropertyValueFactory("edicion"));
        this.columnAutor.setCellValueFactory(new PropertyValueFactory("autor"));
        this.columnStock.setCellValueFactory(new PropertyValueFactory("stock"));
    }

    private void setTable() {
        libros.clear();
        LibroDAO opLibros = new LibroDAO();
        List<Libro> lib = opLibros.getLibros();
        if(!this.libros.containsAll(lib)){
            this.libros.addAll(lib);
            tableLibro.setItems(libros);
        }
    }
}