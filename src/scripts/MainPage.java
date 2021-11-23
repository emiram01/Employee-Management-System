package scripts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class MainPage
{
    @FXML private Button addEmployeeButton;
    @FXML private Button viewEmployeesButton;
    @FXML private Button logoutButton;

    public void addEmployee(ActionEvent event) throws IOException
    {
        App app = new App();
        app.changeScene("addEmployeePage.fxml");
    }

    public void viewEmployees(ActionEvent event) throws IOException
    {
        App app = new App();
        app.changeScene("employeePage.fxml");
    }

    public void logOut(ActionEvent event) throws IOException
    {
        App app = new App();
        app.changeScene("login.fxml");
    }
}
