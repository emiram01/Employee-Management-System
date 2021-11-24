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
    @FXML private TextField employeeName;
    @FXML private TextField employeeSalary;
    @FXML private TextField employeePhoneNum;
    @FXML private TextField employeeAddress;
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
        if(employeeID.getText().equals("") || employeeName.getText().equals("") || employeeSalary.getText().equals("") ||employeeAddress.getText().equals("")||employeePhoneNum.getText().equals(""))
        {
            addEmpText.setText("Missing info, please try agian.");  
        }
        else
        {
            String name = employeeName.getText();
            String id = employeeID.getText();
            String salary = employeeSalary.getText();
            String address = employeeAddress.getText();
            String phone = employeePhoneNum.getText();
            employeeID.setText("");
            employeeName.setText("");
            employeeSalary.setText("");
            employeeAddress.setText("");
            employeePhoneNum.setText("");

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
