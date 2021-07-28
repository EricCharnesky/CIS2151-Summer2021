package guicontrols;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class GUIControlsController implements Initializable {

    @FXML
    private CheckBox bagelCheckBox;
    @FXML
    private RadioButton bagelPlainOPtion;
    @FXML
    private ToggleGroup bagelOptions;
    @FXML
    private RadioButton baeglButterOption;
    @FXML
    private RadioButton bagelCreamCheeseOption;
    @FXML
    private Label receiptLabel;
    @FXML
    private CheckBox sandwichButton;
    @FXML
    private CheckBox sandwichMeatCheckbox;
    @FXML
    private CheckBox sandwichCheeseCheckbox;
    @FXML
    private CheckBox sandwichTomatoesCheckbox;
    @FXML
    private CheckBox sandwichCucumbersCheckbox;
    @FXML
    private ListView<String> coffeListView;
    @FXML
    private Label listViewLabel;
    ObservableList<String> observableList;

    @FXML
    private TextField newItemTextField;
    @FXML
    private Slider slider;
    @FXML
    private Label sliderLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        checkForBagelReceipt();
        checkForSandwichReceipt();

        observableList = FXCollections.observableArrayList(new String[]{
            "Black coffee", "Cold Brew Coffee", "Espresso",
            "Americano", "Flat White", "Cappucinno"});
        coffeListView.setItems(observableList);

        coffeListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        slider.valueProperty().addListener((observable, oldvalue, newvalue)
                -> {
            sliderLabel.setText(newvalue.toString());
        });

    }

    @FXML
    private void updateReceipt(ActionEvent event) {
        buildReceipt();
    }

    private void buildReceipt() {
        ReceiptItem bagelItem = checkForBagelReceipt();
        ReceiptItem sandwichItem = checkForSandwichReceipt();
        String receipt = bagelItem.getDescription() + "\n" + sandwichItem.getDescription();
        receipt += String.format("\nTotal Cost: $%.2f",
                (bagelItem.getCost() + sandwichItem.getCost()));
        receiptLabel.setText(receipt);
    }

    private ReceiptItem checkForBagelReceipt() {
        String receipt = "";
        if (bagelCheckBox.isSelected()) {
            bagelPlainOPtion.setVisible(true);
            baeglButterOption.setVisible(true);
            bagelCreamCheeseOption.setVisible(true);
            if (bagelPlainOPtion.isSelected()) {
                receipt = "Plain Bagel $1.00";
            } else if (baeglButterOption.isSelected()) {
                receipt = "Bagel with butter $1.00";
            } else if (bagelCreamCheeseOption.isSelected()) {
                receipt = "Bagel with cream cheese $1.00";
            }
        } else {
            bagelPlainOPtion.setVisible(false);
            baeglButterOption.setVisible(false);
            bagelCreamCheeseOption.setVisible(false);
        }

        return new ReceiptItem(receipt, 1.0);
    }

    private ReceiptItem checkForSandwichReceipt() {
        String receipt = "";
        double price = 0;
        if (sandwichButton.isSelected()) {
            price = 2;
            setSandwichOptionsVisible(true);
            if (sandwichMeatCheckbox.isSelected()) {
                receipt += "\n with meat";
                price += 1;
            }
            if (sandwichCheeseCheckbox.isSelected()) {
                receipt += "\n with cheese";
                price += .5;
            }
            if (sandwichCucumbersCheckbox.isSelected()) {
                receipt += "\n with cucumbers";
            }
            if (sandwichTomatoesCheckbox.isSelected()) {
                receipt += "\n with tomatoes";
            }

            receipt = String.format("Sandwich $%.2f", price) + receipt;
        } else {

            setSandwichOptionsVisible(false);
        }
        return new ReceiptItem(receipt, price);
    }

    private void setSandwichOptionsVisible(boolean visible) {
        sandwichCheeseCheckbox.setVisible(visible);
        sandwichCucumbersCheckbox.setVisible(visible);
        sandwichMeatCheckbox.setVisible(visible);
        sandwichTomatoesCheckbox.setVisible(visible);
    }

    @FXML
    private void cofeeListViewClicked(MouseEvent event) {
        listViewLabel.setText("");
        for (String item : coffeListView.getSelectionModel().getSelectedItems()) {
            listViewLabel.setText(listViewLabel.getText() + item + " ");
        }
    }

    @FXML
    private void addNewItem(ActionEvent event) {
        if (!newItemTextField.getText().trim().equals("")) {
            observableList.add(newItemTextField.getText());
        }
    }

}
