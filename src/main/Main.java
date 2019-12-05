package main;
	
import java.util.ArrayList;
import java.util.List;

import application.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	static AnchorPane root;
	public static List<GridPane> gridArray = new ArrayList<GridPane>();
	@Override
	public void start(Stage primaryStage) {
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view1/Anchor.fxml"));
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view1/view1.fxml"));
			LoginController controller = new LoginController();
			loader.setController(controller);
			GridPane newGridPane = (GridPane) loader.load();
			gridArray.add(newGridPane);
			root.getChildren().add(gridArray.get(0));
			Scene scene = new Scene(root, 800,600);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}