package library.controllers.frame_profiles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import library.entities.FrameProfile;
import library.entities.FrameWarehouseBalance;
import library.repository.Frame_profileRepository;
import library.repository.Frame_profile_warehouse_balanceRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class Frame_profile_warehouse_balanceAddController implements Initializable {

    private final Frame_profileRepository frameProfileRepository = new Frame_profileRepository();
    private final Frame_profile_warehouse_balanceRepository frameprofilewarehousebalanceRepository = new Frame_profile_warehouse_balanceRepository();

    @FXML private TextField frame_bar_count;
    @FXML private TextField frame_total_length;
    @FXML private TextField frame_id;

    @FXML private StackPane rootPane;

    private FrameWarehouseBalance editable;

    private Runnable closeDialogCallback;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void addPostOperationCallback(Runnable callback) {
        this.closeDialogCallback = callback;
    }

    public void setEditable(FrameWarehouseBalance frameWarehouseBalance) {
        this.editable = frameWarehouseBalance;
        this.frame_bar_count.setText(frameWarehouseBalance.getFrame_bar_count());
        this.frame_total_length.setText(frameWarehouseBalance.getFrame_total_length());
        this.frame_id.setText(frameWarehouseBalance.getFrameProfile().getFrame_id().toString());
    }

    @FXML
    private void addFrame_profile_warehouse_balance(ActionEvent event) {
        String frame_profile_warehouse_balanceFrame_bar_count = frame_bar_count.getText();
        String frame_profile_warehouse_balanceFrame_total_length = frame_total_length.getText();
        String frame_profile_warehouse_balanceFrame_id = frame_id.getText();

        if (frame_profile_warehouse_balanceFrame_bar_count.isEmpty() || frame_profile_warehouse_balanceFrame_total_length.isEmpty() || frame_profile_warehouse_balanceFrame_id.isEmpty()) {
            //TODO: show user alert that all fields have to be filled
            System.out.println("Please fill in all fields!");
            return;
        }

        Long frame_id = Long.parseLong(frame_profile_warehouse_balanceFrame_id);
        FrameProfile frameProfile = frameProfileRepository.findOne(frame_id);
        if (frameProfile == null) {
            //TODO: frameProfile with such ID doesn't exist, display error to user!
            System.out.println("Frame profile with such ID doesn't exist!");
            return;
        }

        if (editable == null) {
            frameprofilewarehousebalanceRepository.save(new FrameWarehouseBalance(frame_profile_warehouse_balanceFrame_bar_count, frame_profile_warehouse_balanceFrame_total_length, frameProfile));
        } else {
            FrameWarehouseBalance frameWarehouseBalance = frameprofilewarehousebalanceRepository.findOne(editable.getId());
            frameWarehouseBalance.setFrame_bar_count(frame_profile_warehouse_balanceFrame_bar_count);
            frameWarehouseBalance.setFrame_total_length(frame_profile_warehouse_balanceFrame_total_length);
            frameWarehouseBalance.setFrameProfile(frameProfile);
            frameprofilewarehousebalanceRepository.merge(frameWarehouseBalance);
        }
        clearEntries();
        closeStage();
        closeDialogCallback.run();
    }

    @FXML
    private void cancel(ActionEvent event) {
        closeStage();
    }

    private void clearEntries() {
        editable = null;
        frame_bar_count.clear();
        frame_total_length.clear();
        frame_id.clear();
    }

    private void closeStage() {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }
}
