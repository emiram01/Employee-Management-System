package scripts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application
{
    private static Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Employee Management System");
        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.show();
    }

    public void changeScene(String fxml) throws IOException
    {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        window.getScene().setRoot(pane);
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}