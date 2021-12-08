package scripts;

import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class EditPage
{
    public static String oldID;
    public static String oldName1;
    public static String oldName2;
    public static String oldSalary1;
    public static String oldSalary2;
    public static String oldPhoneNum1;
    public static String oldPhoneNum2;
    public static String oldPhoneNum3;
    public static String oldAddress1;
    public static String oldAddress2;
    public static String oldAddress3;

    @FXML private Button backButton;
    @FXML private Button logoutButton;
    @FXML private TextField employeeID;
    @FXML private TextField employeeName1;
    @FXML private TextField employeeName2;
    @FXML private TextField employeeSalary1;
    @FXML private TextField employeeSalary2;
    @FXML private TextField employeePhoneNum1;
    @FXML private TextField employeePhoneNum2;
    @FXML private TextField employeePhoneNum3;
    @FXML private TextField employeeAddress1;
    @FXML private TextField employeeAddress2;
    @FXML private TextField employeeAddress3;
    @FXML private Button submitButton;
    @FXML private Label addEmpText;

    @FXML
    public void initialize()
    {
        setTextFields();
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

    public void checkSubmit(ActionEvent event) throws IOException
    {
        validate();
    }

    private void setTextFields()
    {
        employeeID.setText(oldID);
        employeeName1.setText(oldName1);
        employeeName2.setText(oldName2);
        employeeSalary1.setText(oldSalary1);
        employeeSalary2.setText(oldSalary2);
        employeeAddress1.setText(oldAddress1);
        employeeAddress2.setText(oldAddress2);
        employeeAddress3.setText(oldAddress3);
        employeePhoneNum1.setText(oldPhoneNum1);
        employeePhoneNum2.setText(oldPhoneNum2);
        employeePhoneNum3.setText(oldPhoneNum3);
    }

    private void validate() throws IOException
    {
        if(employeeID.getText().equals("") || employeeName1.getText().equals("") || employeeName2.getText().equals("") || employeeSalary1.getText().equals("") || 
           employeeSalary2.getText().equals("") || employeeAddress1.getText().equals("") || employeeAddress2.getText().equals("") || employeeAddress3.getText().equals("") ||
           employeePhoneNum1.getText().equals("") || employeePhoneNum2.getText().equals("") || employeePhoneNum3.getText().equals(""))
        {
            addEmpText.setText("Missing info, please try again.");  
        }
        else if(employeeSalary1.getText().matches(".*[a-z].*") || employeeSalary2.getText().matches(".*[a-z].*") || employeeSalary2.getText().length() != 2)
        {
            addEmpText.setText("Please enter a valid salary.");  
        }
        else if(employeePhoneNum1.getText().matches(".*[a-z].*") || employeePhoneNum2.getText().matches(".*[a-z].*") || employeePhoneNum3.getText().matches(".*[a-z].*") ||
        employeePhoneNum1.getText().length() != 3 || employeePhoneNum2.getText().length() != 3|| employeePhoneNum3.getText().length() != 4)
        {
            addEmpText.setText("Please enter a valid phone number.");  
        }
        else
        {
            DeleteEmployee.delete(oldID);
            String name = employeeName1.getText().replaceAll(" ", "") + " " + employeeName2.getText().replaceAll(" ", "");
            String id = employeeID.getText().replaceAll(" ", "");
            String salary = "$" + employeeSalary1.getText().replaceAll(" ", "") + "." + employeeSalary2.getText().replaceAll(" ", "").substring(0, 2);
            String address = employeeAddress1.getText().replaceAll(" ", "") + " " + employeeAddress2.getText().replaceAll(" ", "") + " " + employeeAddress3.getText().replaceAll(" ", "");
            String phone = "(" + employeePhoneNum1.getText().replaceAll(" ", "").substring(0, 3) + ")" + employeePhoneNum2.getText().replaceAll(" ", "").substring(0, 3) + "-" + employeePhoneNum3.getText().replaceAll(" ", "").substring(0, 4);

            try(FileWriter fw = new FileWriter("src/data/EmployeeData.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                fw.write("\n");
                fw.write(id);
                fw.write(" ");
                fw.write(name);
                fw.write(" ");
                fw.write(address);
                fw.write(" ");
                fw.write(phone);
                fw.write(" ");
                fw.write(salary);
                fw.close();
                addEmpText.setText("Employee Profile Saved");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
