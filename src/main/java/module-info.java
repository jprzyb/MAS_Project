module pl.pjatk.mas.s24512.masproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens pl.pjatk.mas.s24512.masproject to javafx.fxml;
    exports pl.pjatk.mas.s24512.masproject;
}