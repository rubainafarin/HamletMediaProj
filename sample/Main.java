package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    public int resX = 1000; //resolution width
    public int resY = 1000; //resolution height
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Variables.
        Button button1 = new Button(); //new game button
        Button button2 = new Button(); //exit button
        AnchorPane root = new AnchorPane(); //add nodes/children to this to display on main menu
        AnchorPane mainGame = new AnchorPane(); //add nodes/children to this to display on main game
        Scene mainScene = new Scene(mainGame, resX, resY); //main game scene
        Scene scene = new Scene(root, resX, resY); //main menu scene
        //**********************


        primaryStage.setTitle("Hamlet!");

        //new game button i.e. enter game or whatever
        button1.setText("New Game");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(mainScene); //sets scene to mainScene which is the main game
            }
        });
        //******************

        //button to exit
        button2.setText("Exit"); //button to exit game
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit(); //exits game
            }
        });
        //******************

        //button x, y
        button1.setLayoutX(61);
        button1.setLayoutY(410);
        button2.setLayoutX(61);
        button2.setLayoutY(599);
        //*******************
        //adds buttons
        root.getChildren().add(button2);
        root.getChildren().add(button1);
        //*******************

        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
