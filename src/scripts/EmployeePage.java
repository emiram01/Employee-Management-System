package scripts;

import java.io.File;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class EmployeePage
{
    public File employeeData;

    @FXML private Button backButton;
    @FXML private Button logoutButton;

    @FXML private TableView<Employee> table;
    @FXML private TableColumn<Employee, Integer> idCol;
    @FXML private TableColumn<Employee, String> nameCol;
    @FXML private TableColumn<Employee, String> addressCol;
    @FXML private TableColumn<Employee, String> phoneNumberCol;
    @FXML private TableColumn<Employee, Integer> salaryCol;
    
    @FXML
    public void initialize()
    {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));

        table.setItems(getEmployees());
    }

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

    private ObservableList<Employee> getEmployees()
    {
        ObservableList<Employee> employees = FXCollections.observableArrayList();
        
        try
        {
            employeeData = new File("src/data/EmployeeData.txt");
            Scanner s = new Scanner(employeeData);
            while(s.hasNextLine())
            {
                String id = s.next();
                String name = s.next() + " " + s.next();
                String address = s.next() + " " + s.next() + " " + s.next();
                String phoneNumber = s.next();
                String salary = s.next();

                employees.add(new Employee(id, name, address, phoneNumber, salary));
            }

            s.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        return employees;
    }
}
