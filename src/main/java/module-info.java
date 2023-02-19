module fx.masterclass.helloworldfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


//    opens java.masterclass.helloworldfx to javafx.fxml;
//    exports java.masterclass.helloworldfx

    opens fx.masterclass.helloworldfx;
    opens fx.masterclass.layouts;
    opens fx.masterclass.controls;
    opens fx.masterclass.events;
    opens fx.masterclass.cssJavaFx;


}