module com.c2306l.s4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires java.sql;

    opens com.c2306l.s4 to javafx.fxml;
    exports com.c2306l.s4;
}