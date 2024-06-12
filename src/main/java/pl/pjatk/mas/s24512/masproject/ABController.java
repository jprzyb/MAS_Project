package pl.pjatk.mas.s24512.masproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.pjatk.mas.s24512.masproject.Models.CommunicationPlannerManager;

import java.net.URL;
import java.util.ResourceBundle;

public class ABController implements Initializable {
    @FXML
    TextField annualBonusField;
    @FXML
    Label infoLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        annualBonusField.setText(String.valueOf(CommunicationPlannerManager.getAnnualBonus()));
    }

    public static void showAnnualBonusWindow(CPMController parent){
        try {
            FXMLLoader loader = new FXMLLoader(ABController.class.getResource("annual-bonus-change.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Annual bonus change");
            stage.show();
            stage.setOnHiding((windowEvent -> parent.afterAnnualBonusChangeClose()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onSetButtonClick(ActionEvent event){
        if(isDouble(annualBonusField.getText())){
            CommunicationPlannerManager.setAnnualBonus(Double.parseDouble(annualBonusField.getText()));
            onCancelButtonClick(event);
        }
        else infoLabel.setText("Wrong bonus value (should be like 100.99)");
    }

    @FXML
    private void onCancelButtonClick(ActionEvent event){
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    private boolean isDouble(String value) {
        if (value == null || value.isEmpty()) return false;
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
