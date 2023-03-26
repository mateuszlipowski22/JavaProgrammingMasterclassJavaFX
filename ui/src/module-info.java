module ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires db;

    exports ui;
    opens ui;
}