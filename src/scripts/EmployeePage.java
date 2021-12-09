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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;

public class EmployeePage
{
    public File employeeData;

    @FXML private Button backButton;
    @FXML private Button logoutButton;
    @FXML private Button editButton;
    @FXML private Button deleteButton;
    @FXML private Button scheduleButton;
    @FXML private TextField idField;
    @FXML private Text errorText;

    @FXML public TableView<Employee> table;
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

    public void edit(ActionEvent event) throws IOException
    {
        if(!idField.getText().isEmpty())
        {
            if(checkID(idField.getText()))
            {
                App app = new App();
                setOldEmployeeInfo(idField.getText());
                app.changeScene("editPage.fxml");
            }
            else
                errorText.setText("ID does not exist");
        }
        else
            errorText.setText("Please enter an ID");
    }

    public void delete(ActionEvent event) throws IOException
    {
        if(!idField.getText().isEmpty())
        {
            if(checkID(idField.getText()))
            {
                DeleteEmployee.delete(idField.getText());
                App app = new App();
                app.changeScene("employeePage.fxml");
            }
            else
                errorText.setText("ID does not exist");
        }
        else
            errorText.setText("Please enter an ID");
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

    private boolean checkID(String id)
    {
        return table.getItems().stream().anyMatch(item -> item.getId().equals(id));
    }

    private void setOldEmployeeInfo(String id)
    {
        try
        {
            employeeData = new File("src/data/EmployeeData.txt");
            Scanner s = new Scanner(employeeData);
            while(s.hasNext())
            {
                if(s.next().equals(id))
                {
                    EditPage.oldID = id;
                    EditPage.oldName1 = s.next();
                    EditPage.oldName2 = s.next();
                    EditPage.oldAddress1 = s.next();
                    EditPage.oldAddress2 = s.next();
                    EditPage.oldAddress3 = s.next();
                    String pNum = s.next().toString();
                    EditPage.oldPhoneNum1 = pNum.substring(1, 4);
                    EditPage.oldPhoneNum2 = pNum.substring(5, 8);
                    EditPage.oldPhoneNum3 = pNum.substring(9, 13);
                    String sal = s.next().toString();
                    EditPage.oldSalary1 = sal.substring(1, sal.length() - 3);
                    EditPage.oldSalary2 = sal.substring(sal.length() - 2);
                    break;
                }

                s.nextLine();
            }

            s.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
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
                if(!s.hasNext())
                    break;

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
