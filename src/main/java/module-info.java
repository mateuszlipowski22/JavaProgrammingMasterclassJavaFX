module fx.masterclass.helloworldfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


//    opens java.masterclass.helloworldfx to javafx.fxml;
//    exports java.masterclass.helloworldfx

    opens fx.masterclass.helloworldfx;
    opens fx.masterclass.layouts;
    opens fx.masterclass.controls;
    opens fx.masterclass.events;
    opens fx.masterclass.cssJavaFx;
    opens fx.masterclass.sceneBuildier;
    opens fx.masterclass.myContacts;
    opens fx.masterclass.myContacts.datamodel;
    opens fx.masterclass.MusicUI;
    opens fx.masterclass.MusicUI.model;


}