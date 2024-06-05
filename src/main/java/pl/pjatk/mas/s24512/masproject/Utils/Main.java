package pl.pjatk.mas.s24512.masproject.Utils;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.pjatk.mas.s24512.masproject.DBUtils.DB;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MAS_s24512_GUI");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        new DB();
        launch();
    }
}