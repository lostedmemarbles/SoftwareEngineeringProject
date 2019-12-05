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
import models.Store;

/**
 * @author Paul Lapsley
 * @author Michael Chapa
 * AppController is a singleton that controls view switching, holds the current store data, and
 * the app's menu bar
 */
public class AppController implements Initializable{
	// instance variables
	public static final int MAIN_VIEW = 0, GRAPH_MAIN_VIEW = 1, DELETE_RECORD_VIEW = 2, UPDATE_RECORD_VIEW = 3,
							GRAPH_PURCHASE = 4, GRAPH_SALES = 5 , GRAPH_TOTAL = 6, NEW_RECORD_VIEW = 7, TABLE_VIEW = 5000, GRAPH_VIEW=1000;
	private int currentView;
	private static BorderPane rootPane;
	private Store store;
	// private AppMenuBar appMenuBar = new AppMenuBar();


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

	public void setData(Store store){
		this.store = store;
	}
/**
 * changeView changes the view in the program
 * @param viewType The view to switch to. They are defined as constant ints
 * @param store The store data file
 */
	public void changeView(int viewType, Store store){
		try{
			FXMLLoader loader = null;
			currentView = viewType;
			switch(viewType){
				case MAIN_VIEW:
					loader = new FXMLLoader(getClass().getResource("/main/main.fxml"));
					loader.setController(this);
					break;
					/*
				case GRAPH_MAIN_VIEW:
					loader = new FXMLLoader(Launcher.class.getResource("/inventory_graph/inventoryGraph.fxml"));
					InventoryGraphController graphController = new InventoryGraphController();
					graphController.setData(store);
					loader.setController(graphController);
					break;
				case GRAPH_PURCHASE:
					loader = new FXMLLoader(Launcher.class.getResource("/purchase_graph/purchaseGraph.fxml"));
					PurchaseGraphController purchaseGraphController = new PurchaseGraphController();
					purchaseGraphController.setData(store);
					loader.setController(purchaseGraphController);
					break;
				case GRAPH_SALES:
					loader = new FXMLLoader(Launcher.class.getResource("/sales_graph/salesGraph.fxml"));
					SalesGraphController salesGraphController = new SalesGraphController();
					salesGraphController.setData(store);
					loader.setController(salesGraphController);
					break;
				case GRAPH_TOTAL:
					loader = new FXMLLoader(Launcher.class.getResource("/totals_graph/totalsGraph.fxml"));
					TotalsGraphController totalGraphController = new TotalsGraphController();
					totalGraphController.setData(store);
					loader.setController(totalGraphController);
					break;
				case NEW_RECORD_VIEW:
					loader = new FXMLLoader(Launcher.class.getResource("/newRecord_view/newRecord.fxml"));
					AddRecordController addRecordController = new AddRecordController();
					loader.setController(addRecordController);
					break;
				case UPDATE_RECORD_VIEW:
					loader = new FXMLLoader(Launcher.class.getResource("/updateRecord_view/updateRecord.fxml"));
					UpdateRecordController updateRecordController = new UpdateRecordController();
					loader.setController(updateRecordController);
					break;
				case DELETE_RECORD_VIEW:
					loader = new FXMLLoader(Launcher.class.getResource("/deleteRecord_view/deleteRecord.fxml"));
					DeleteRecordController deleteRecordController = new DeleteRecordController(store);
					loader.setController(deleteRecordController);
					break;
				case TABLE_VIEW:
					loader = new FXMLLoader(Launcher.class.getResource("/table_view/table_view.fxml"));
					TableController tableController = new TableController(store);
					loader.setController(tableController);
					break;*/
			}
			// Set new view in the Stage
			if(viewType != GRAPH_VIEW) {
				Parent view = loader.load();

				rootPane.setTop(view);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void refresh() {
		changeView(currentView, store);
	}


    public void initialize(URL location, ResourceBundle resources) {

    }

    // Accessors
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	/*
	public AppMenuBar getAppMenuBar() {
		return appMenuBar;
	}
	public void setAppMenuBar(AppMenuBar appMenuBar) {
		this.appMenuBar = appMenuBar;
	}*/


}
