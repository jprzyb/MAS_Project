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
import pl.pjatk.mas.s24512.masproject.DBUtils.AnnualBonuses;

import java.net.URL;
import java.util.ResourceBundle;

public class AnnualBonusChangeController implements Initializable {
    @FXML
    TextField annualBonusField;
    @FXML
    Label infoLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Util.loggedOnEmployee.getRole().contains("Planner")) annualBonusField.setText(String.valueOf(AnnualBonuses.getAnnualBonusForPlanners()));
        else if (Util.loggedOnEmployee.getRole().contains("Traffic")) annualBonusField.setText(String.valueOf(AnnualBonuses.getAnnualBonusForTraffics()));
    }

    public static void showAnnualBonusWindow(CommunicationPlannerManagerController parent){
        try {
            FXMLLoader loader = new FXMLLoader(MyInformationController.class.getResource("annual-bonus-change.fxml"));
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
        boolean flag = false;
        if(isDouble(annualBonusField.getText())){
            if (Util.loggedOnEmployee.getRole().equals("Planner Manager")) {
                flag = AnnualBonuses.setAnnualBonusForPlanners(Double.parseDouble(annualBonusField.getText()));
            }
            else if (Util.loggedOnEmployee.getRole().equals("Traffic Manager") || Util.loggedOnEmployee.getRole().equals("Traffic / Traffic Manager")) {
                flag = AnnualBonuses.setAnnualBonusForTraffics(Double.parseDouble(annualBonusField.getText()));
            }

            if(flag) onCancelButtonClick(event);
            else infoLabel.setText("Something went wrong!");
        }
        else infoLabel.setText("Wrong bonus value (should be like 1234.99)");
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
