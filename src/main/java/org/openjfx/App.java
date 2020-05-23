package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;
import org.openjfx.DAO.EstudianteDAO;
import org.openjfx.DTO.Estudiante;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
//        launch(args);
        EstudianteDAO dao = new EstudianteDAO();
        List<Estudiante> estudiantes = dao.getEstudiantes();
        
        estudiantes.forEach((e) -> {
            System.out.println(e);
        });
        
    }

}