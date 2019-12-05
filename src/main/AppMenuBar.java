package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import controller.AppController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.FileChooser;
import models.Item;
import models.Store;
import views.Views;

/**
 *
 * @author Paul Lapsley
 *
 * This is so you don't have to recreate the menu in every scene
 * and change every copy whenever there is a modification. An object
 * of it is kept in the AppController singleton so you can access it
 * anywhere. It gives the ability to load and save data, as well as
 * switch between the views
 */
public class AppMenuBar implements EventHandler<ActionEvent> {

	private MenuBar menuBar = new MenuBar();

	//
	private Menu fileMenu = new Menu("File");
	private MenuItem importData;
	private MenuItem exportData;
	private MenuItem logout;
	private MenuItem quit;


	public AppMenuBar() {
		createFileMenu();
	}
/**
 * Creates the "File" menu and its menu items.
 */
	public void createFileMenu() {

		importData = new MenuItem("Import Data");
		importData.setOnAction(this);
		fileMenu.getItems().add(importData);

		exportData = new MenuItem("Export Data");
		exportData.setOnAction(this);
		fileMenu.getItems().add(exportData);


		fileMenu.getItems().add(new SeparatorMenuItem());
		
		logout = new MenuItem("Logout");
		logout.setOnAction(this);
		fileMenu.getItems().add(logout);

		quit = new MenuItem("Quit");
		quit.setOnAction(e -> Platform.exit());
		fileMenu.getItems().add(quit);

		menuBar.getMenus().add(fileMenu);
	}


	public MenuBar getMenuBar() {
		return menuBar;
	}
	/**
	 * Handles the events
	 */
	@Override
	public void handle(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("CSV Files (*.csv)", "*.csv");
		fileChooser.getExtensionFilters().add(csvFilter);

		if (event.getSource() == importData) {
			File file = fileChooser.showOpenDialog(null);
			if (file != null) {
				Store store = new Store();
//				try {
//					// store.loadItemsFromFile(file.getPath());
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				}
				// AppController.getInstance().setStore(store);
				AppController.getInstance().refresh();
			}
		}
		
		if (event.getSource() == logout) {
			AppController.getInstance().changeView(Views.LoginScreen);
		}



		else if (event.getSource() == exportData) {
			try {
				File file = fileChooser.showSaveDialog(null);
				if (file != null) {
					FileWriter output = new FileWriter(file);
					ArrayList<Item> items = AppController.getInstance().getStore().getItems();
					for (Item i : items) {
//						output.write(i.getID() + ",");
//						output.write(i.getDescription() + ",");
//						output.write(i.getDepartment() + ",");
//						output.write(i.getUnits() + ",");
//						output.write(i.getPurchases() + ",");
//						output.write(i.getSales() + ",");
//						output.write(i.getMarkdown() + ",");
//						output.write(i.getDamages() + ",");
//						output.write(i.getDonations() + "\n");
					}
					output.flush();
					output.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
