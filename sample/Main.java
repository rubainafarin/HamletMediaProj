package sample;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	public int resX = 1000; //resolution width
	public int resY = 1000; //resolution height

	@Override
	public void start(Stage primaryStage) throws Exception{
		//Variables.
		int b1W = 100; //buttons 1-2, width and height
		int b1H = 100;
		int b2W = 100;
		int b2H = 100;
		int b1X = 450; //buttons 1-2, x and y
		int b1Y = 400;
		int b2X = 450;
		int b2Y = 530;
		
		//*****************
		
		//Title of the game (we can always change the title of the game)
		Image image = new Image(new FileInputStream("src/download.png"));
		ImageView imageView = new ImageView (image);
		imageView.setFitHeight(400);
		imageView.setFitWidth(1500);	
		imageView.setX(250);
		
		//*****************
		
		//Background scroll pane
		
		Image backgroundImage = new Image ( new FileInputStream("src/4ef5ed23dd7614b990195ae96bc6e678.jpg"));
		StackPane layout = new StackPane();
		layout.getChildren().setAll(new ImageView (backgroundImage));

		ScrollPane scroll = createScrollPane(layout);

		
		//**************************

		Button button1 = new Button(); //new game button
		Button button2 = new Button(); //exit button
		AnchorPane root = new AnchorPane(imageView); //add nodes/children to this to display on main menu
		AnchorPane mainGame = new AnchorPane(scroll); //add nodes/children to this to display on main game
		Scene mainScene = new Scene(mainGame, resX, resY); //main game scene
		Scene scene = new Scene(root, resX, resY); //main menu scene
		Text mainTitle = new Text();
		//*********************

		primaryStage.setTitle("Hamlet!");

		//new game button i.e. enter game or whatever
		String styles =
				"-fx-background-color: #ffffff;" +
						"-fx-border-color: #ffffff; " +
						"-fx-font-size: 20;";
		button1.setText("ENTER");
		button1.setStyle(styles);
		button1.setPrefWidth(b1W);
		button1.setPrefHeight(b1H);
		
		button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(mainScene); //sets scene to mainScene which is the main game
			}
		});

		//button to exit
		button2.setText("EXIT"); //button to exit game
		button2.setStyle(styles);
		button2.setPrefWidth(b2W);
		button2.setPrefHeight(b2H);
		button2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit(); //exits game
			}
		});
		//******************

		//button x, y
		button1.setLayoutX(b1X);
		button1.setLayoutY(b1Y);
		button2.setLayoutX(b2X);
		button2.setLayoutY(b2Y);
		//*******************
		//adds buttons
		root.getChildren().add(button2);
		root.getChildren().add(button1);
		root.getChildren().add(mainTitle);
		//*******************

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	//ScrollPane actions

	private ScrollPane createScrollPane(StackPane layout) {
		// TODO Auto-generated method stub
		 ScrollPane scroll = new ScrollPane();
		    scroll.setPannable(true);
		    scroll.setPrefSize(1000, 1000);
		    scroll.setContent(layout);
		    
		    return scroll;
	}
	
	
