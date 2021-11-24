package scripts;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class AddEmployee
{
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

    private void validate() throws IOException
    {
        if(employeeID.getText().equals("") || employeeName1.getText().equals("") || employeeName2.getText().equals("") || employeeSalary1.getText().equals("") || 
           employeeSalary2.getText().equals("") || employeeAddress1.getText().equals("") || employeeAddress2.getText().equals("") || employeeAddress3.getText().equals("") ||
           employeePhoneNum1.getText().equals("") || employeePhoneNum3.getText().equals("") || employeePhoneNum3.getText().equals(""))
        {
            addEmpText.setText("Missing info, please try agian.");  
        }
        else
        {
            String name = employeeName1.getText().replaceAll(" ", "") + " " + employeeName2.getText().replaceAll(" ", "");
            String id = employeeID.getText().replaceAll(" ", "");
            String salary = "$" + employeeSalary1.getText().replaceAll(" ", "") + "." + employeeSalary2.getText().replaceAll(" ", "");
            String address = employeeAddress1.getText().replaceAll(" ", "") + " " + employeeAddress2.getText().replaceAll(" ", "") + " " + employeeAddress3.getText().replaceAll(" ", "");
            String phone = "(" + employeePhoneNum1.getText().replaceAll(" ", "") + ")" + employeePhoneNum2.getText().replaceAll(" ", "") + "-" + employeePhoneNum3.getText().replaceAll(" ", "");
            employeeID.setText("");
            employeeName1.setText("");
            employeeName2.setText("");
            employeeSalary1.setText("");
            employeeSalary2.setText("");
            employeeAddress1.setText("");
            employeeAddress2.setText("");
            employeeAddress3.setText("");
            employeePhoneNum1.setText("");
            employeePhoneNum2.setText("");
            employeePhoneNum3.setText("");

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
