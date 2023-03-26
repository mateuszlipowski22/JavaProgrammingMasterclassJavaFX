module common.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;

    opens common;
    opens db;
    opens ui;

}