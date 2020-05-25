module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.jfoenix;
    requires java.base;

    opens org.openjfx to javafx.fxml;
    exports org.openjfx;
    
    //Para poder llenar las tablas
    opens org.openjfx.DTO to javafx.base;
}