package scripts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class AddEmployee
{
    @FXML private Button backButton;
    @FXML private Button logoutButton;

    public void goBack(ActionEvent event) throws IOException
    {
        App app = new App();
        app.changeScene("mainPage.fxml");
    }

    public void logOut(ActionEvent event) throws IOException
    {
        App app = new App();
        app.changeScene("login.fxml");
    }
}
