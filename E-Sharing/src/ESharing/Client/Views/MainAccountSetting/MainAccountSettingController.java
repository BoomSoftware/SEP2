package ESharing.Client.Views.MainAccountSetting;

import ESharing.Client.Core.ViewHandler;
import ESharing.Client.Core.ViewModelFactory;
import ESharing.Client.Views.ViewController;
import ESharing.Shared.TransferedObject.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import java.util.Optional;

/**
 * The controller class used to manage all functions and components from the fxml file
 * @version 1.0
 * @author Group1
 */
public class MainAccountSettingController extends ViewController {

    @FXML private Pane userSettingPane;

    private ViewHandler viewHandler;
    private MainSettingViewModel mainSettingViewModel;
    private User loggedUser;

    /**
     * Initializes controller with all components
     * @param loggedUser the User object which is current logged in the system
     */
    public void init(User loggedUser)
    {
        this.viewHandler = ViewHandler.getViewHandler();
        this.mainSettingViewModel = ViewModelFactory.getViewModelFactory().getMainSettingViewModel();
        this.loggedUser = loggedUser;
    }

    /**
     * Displays confirmation alert, sends the remove current logged user account request to the view model and goes back to the welcome view
     */
    public void removeAccountButton() {
        Alert removeConfirmation = new Alert(Alert.AlertType.CONFIRMATION);
        removeConfirmation.setTitle("Confirm removing");
        removeConfirmation.setHeaderText(null);
        removeConfirmation.setContentText("Are you sure? This operation can not be restored");
        Optional<ButtonType> result = removeConfirmation.showAndWait();
        if (result.get() == ButtonType.OK) {
            mainSettingViewModel.removeAccount(loggedUser);
            viewHandler.openWelcomeView();
        } else {
            removeConfirmation.close();
        }
    }

    /**
     * Opens a setting view with general user information
     */
    public void loadAboutPane() {
        viewHandler.openUserInfoSettingView(userSettingPane, loggedUser);
    }

    /**
     * Opens a setting view with address information connected with the current logged user
     */
    public void loadAddressPane() {
        viewHandler.openUserAddressSettingView(userSettingPane, loggedUser);
    }
}