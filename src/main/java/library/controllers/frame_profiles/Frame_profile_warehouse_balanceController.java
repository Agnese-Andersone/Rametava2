package library.controllers.frame_profiles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.controllers.view.ViewLoader;
import library.entities.FrameWarehouseBalance;
import library.repository.Frame_profile_warehouse_balanceRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class Frame_profile_warehouse_balanceController implements Initializable {

    private final Frame_profile_warehouse_balanceRepository frameprofilewarehousebalanceRepository = new Frame_profile_warehouse_balanceRepository();

    @FXML
    private TableView<FrameWarehouseBalance> table;

    @FXML
    private void addFrame_profile_balance(ActionEvent event) {
        Frame_profile_warehouse_balanceAddController controller = (Frame_profile_warehouse_balanceAddController) ViewLoader
                .load(getClass().getResource("/ui/frame_profile_warehouse_balance/add_frame_profile_warehouse_balance.fxml"), "Add frame_profile_warehouse_balance");
        controller.addPostOperationCallback(this::populateTable);
    }

    @FXML
    private void deleteFrame_profile_balance(ActionEvent event) {
        FrameWarehouseBalance frameWarehouseBalance = table.getSelectionModel().getSelectedItem();
        if (frameWarehouseBalance == null) {
            return;
        }
        frameprofilewarehousebalanceRepository.delete(frameWarehouseBalance.getId());
        populateTable();
    }

    @FXML
    private void editFrame_profile_balance(ActionEvent event) {
        FrameWarehouseBalance frameWarehouseBalance = table.getSelectionModel().getSelectedItem();
        if (frameWarehouseBalance == null) {
            return;
        }
        Frame_profile_warehouse_balanceAddController controller = (Frame_profile_warehouse_balanceAddController) ViewLoader.load(getClass()
                .getResource("/ui/frame_profile_warehouse_balance/add_frame_profile_warehouse_balance.fxml"), "Edit frameWarehouseBalance");
        controller.setEditable(frameWarehouseBalance);
        controller.addPostOperationCallback(this::populateTable);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureTable();
        populateTable();
    }

    private void configureTable() {
        TableColumn<FrameWarehouseBalance, Long> column1 = new TableColumn<>("frame_id");
        column1.setCellValueFactory(new PropertyValueFactory<>("frame_id"));

        TableColumn<FrameWarehouseBalance, String> column2 = new TableColumn<>("frame_name");
        column2.setCellValueFactory(new PropertyValueFactory<>("frame_name"));

        TableColumn<FrameWarehouseBalance, String> column3 = new TableColumn<>("frame_bar_count");
        column3.setCellValueFactory(new PropertyValueFactory<>("frame_bar_count"));

        TableColumn<FrameWarehouseBalance, String> column4 = new TableColumn<>("frame_total_length");
        column4.setCellValueFactory(new PropertyValueFactory<>("frame_total_length"));

        table.getColumns().add(column1);
        table.getColumns().add(column2);
        table.getColumns().add(column3);
        table.getColumns().add(column4);
    }

    private void populateTable() {
        ObservableList<FrameWarehouseBalance> list = FXCollections.observableArrayList();
        list.addAll(frameprofilewarehousebalanceRepository.findAll());
        table.setItems(list);
    }
}
