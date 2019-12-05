package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import main.AppMenuBar;
import models.Store;
import views.Views;


/**
 * @author Paul Lapsley
 * AppController is a singleton that controls view switching, holds the current store data, and
 * the app's menu bar
 */
public class AppController implements Initializable{
	// instance variables
	private Views currentView;
	private static BorderPane rootPane;
	private Store store = new Store("Food Library");
	private AppMenuBar appMenuBar = new AppMenuBar();


	// Singleton Start
	private static AppController myInstance;

	private AppController() {
		myInstance = null;
	}
	
	public static AppController getInstance() {
		if (myInstance == null)
			myInstance = new AppController();
		return myInstance;
	}

	// Singleton End

	public void setRootPane(BorderPane rootPane){
		this.rootPane = rootPane;
	}

/**
 * changeView changes the view in the program
 * @param viewType The view to switch to. They are defined as constant ints
 * @param store The store data file
 */
	public void changeView(Views viewType){
		try{
			FXMLLoader loader = null;
			currentView = viewType;
			switch(viewType){
				case Home:
					// loader = new FXMLLoader(getClass().getResource("/main/main.fxml"));
					loader.setController(this);
					break;
					
				default:
					break;

			}
			
			
			Parent view = loader.load();
			rootPane.setTop(view);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}


	public void refresh() {
		changeView(currentView);
	}


    public void initialize(URL location, ResourceBundle resources) {

    }

    // Accessors
	public Store getStore() {
		return store;
	}
	public AppMenuBar getAppMenuBar() {
		return appMenuBar;
	}
	public void setAppMenuBar(AppMenuBar appMenuBar) {
		this.appMenuBar = appMenuBar;
	}


}


