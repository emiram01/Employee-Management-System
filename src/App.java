import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application
{
    private Stage window;
    private Scene loginPage, mainPage; 

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;

        Label label1 = new Label("Welcome!");
        Button button1 = new Button("Go to main page.");
        button1.setOnAction(e -> window.setScene(mainPage));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        loginPage = new Scene(layout1, 200, 200);

        Button button2 = new Button("Go back to login page.");
        button2.setOnAction(e -> window.setScene(loginPage));

        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(button2);
        mainPage = new Scene(layout2, 600, 300);

        window.setScene(loginPage);
        window.setTitle("Employee Management System");
        window.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}