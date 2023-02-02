module fx.masterclass.helloworldfx {
    requires javafx.controls;
    requires javafx.fxml;


//    opens java.masterclass.helloworldfx to javafx.fxml;
//    exports java.masterclass.helloworldfx

    opens fx.masterclass.helloworldfx;
    opens fx.masterclass.layouts;


}