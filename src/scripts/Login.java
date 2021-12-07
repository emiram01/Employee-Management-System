package scripts;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.event.ActionEvent;

public class Login
{
    public Login()
    {

    }

    @FXML private Button loginButton;
    @FXML private Label loginText;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    public void checkLogin(ActionEvent event) throws IOException
    {
        validate();
    }

    private void validate() throws IOException
    {
        App app = new App();
        AppSettings settings = new AppSettings();

        if(usernameField.getText().toString().toLowerCase().equals(settings.getUserName()) && passwordField.getText().toString().equals(settings.getPassword()))
        {
            loginText.setText("");
            app.changeScene("mainPage.fxml");
        }
        else if(usernameField.getText().isEmpty() && passwordField.getText().isEmpty())
            loginText.setText("Please enter your username and password.");

        else if(usernameField.getText().isEmpty())
            loginText.setText("Please enter your username.");

        else if(passwordField.getText().isEmpty())
            loginText.setText("Please enter your password.");

        else
            loginText.setText("Wrong username or password, please try again.");
    }
}
