/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.openjfx.DAO.EstudianteDAO;
import org.openjfx.DAO.LibroDAO;
import org.openjfx.DAO.PrestamoDAO;
import org.openjfx.DTO.Estudiante;
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
    @FXML
    private TableColumn<?, ?> columnEditorial;

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

        if (obj == buttonProcesar) {
            //Acciones para procesar prestamo
            if (!textCarnet.getText().equals("") && textCarnet.getText().length()==9) {
                String carnet = textCarnet.getText();
                Libro tmp = tableLibro.getSelectionModel().getSelectedItem();
                if (tmp != null) {
                    EstudianteDAO estDAO = new EstudianteDAO();
                    Estudiante estudiante = estDAO.getEstudiantebyCarnet(carnet);

                    LibroDAO libDAO = new LibroDAO();
                    Libro libro = libDAO.getLibrobyId(tmp.getId_libro());

                    if(libro.getStock() > 0){
                        if (estudiante == null) {
                            try {
                                //Nuevo estudiante
                                registrarEstudianteNuevo(carnet);
                            } catch (IOException ex) {
                                ex.printStackTrace(System.out);
                            }
                        } else{
                            procesarPrestamo(estudiante, libro);
                        }
                    }
                } else {
                    //Alerta
                }
            } else {
                //Alerta
            }
        } else if (obj == buttonCancelar) {
            this.buttonCancelar.getScene().getWindow().hide();
        }
    }
    
    private void registrarEstudianteNuevo(String carnet) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/NuevoEstudiante.fxml"));
        Parent root = loader.load();
        NuevoEstudianteController controller = loader.getController();
        controller.initializeElements(carnet);
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Nuevo Estudiante");
        stage.setScene(scene);
        stage.showAndWait();
    }
    
    private void procesarPrestamo(Estudiante estudiante, Libro libro) {
        PrestamoDAO prestamosDAO = new PrestamoDAO();
        int prestamosEst = prestamosDAO.getNumeroPrestamos(estudiante);
        
        if(prestamosEst <2){
            //Accione para procesar prestamo;
        }else{
            //Alerta
        }
    }    

    private void createTable() {
        libros = FXCollections.observableArrayList();
        this.columnCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        this.columnNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.columnEdicion.setCellValueFactory(new PropertyValueFactory("edicion"));
        this.columnAutor.setCellValueFactory(new PropertyValueFactory("autor"));
        this.columnEditorial.setCellValueFactory(new PropertyValueFactory("editorial"));
        this.columnStock.setCellValueFactory(new PropertyValueFactory("stock"));
    }

    private void setTable() {
        libros.clear();
        LibroDAO opLibros = new LibroDAO();
        List<Libro> lib = opLibros.getLibros();
        if (!this.libros.containsAll(lib)) {
            this.libros.addAll(lib);
            tableLibro.setItems(libros);
        }
    }

    @FXML
    private void ActionTextLibro(KeyEvent event) {
        String busqueda = textLibro.getText();
        if (!busqueda.equals("")) {
            busqueda = "%" + busqueda + "%";
            LibroDAO libroDAO = new LibroDAO();
            List<Libro> libs = libroDAO.getLibrosForSearch(busqueda);
            libros.clear();
            if (!this.libros.containsAll(libs)) {
                this.libros.addAll(libs);
                tableLibro.setItems(libros);
            }
        } else {
            setTable();
        }
    }
}
