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
    @FXML private TextField username;
    @FXML private PasswordField password;

    public void checkLogin(ActionEvent event) throws IOException
    {
        validate();
    }

    private void validate() throws IOException
    {
        App app = new App();

        if(username.getText().toString().equals("abhishek") && password.getText().toString().equals("comp380"))
        {
            loginText.setText("");
            app.changeScene("mainPage.fxml");
        }
        else if(username.getText().isEmpty() && password.getText().isEmpty())
            loginText.setText("Please enter your username and password.");

        else if(username.getText().isEmpty())
            loginText.setText("Please enter your username.");

        else if(password.getText().isEmpty())
            loginText.setText("Please enter your password.");

        else
            loginText.setText("Wrong username or password, please try again.");
    }
}
