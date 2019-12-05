package controller;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import models.Department;
import models.Item;
import models.Markdown;
import models.Store;

/**
 * 
 * @author Paul Lapsley
 * TableController controls the Table view, showing
 * information for the inventory.
 *
 */
public class TableController  implements Initializable {
	
	@FXML
	private BorderPane pane;
	@FXML
	private TableView<Item> itemTable;
	@FXML
	private TableColumn<Item, Integer> idColumn;
	@FXML
	private TableColumn<Item, String> descriptionColumn;
	@FXML
	private TableColumn<Item, Department> departmentColumn;
	@FXML
	private TableColumn<Item, Integer> unitsColumn;
	@FXML
	private TableColumn<Item, BigDecimal> purchasesColumn;
	@FXML
	private TableColumn<Item, BigDecimal> salesColumn;
	@FXML
	private TableColumn<Item, Markdown> markdownColumn;
	@FXML
	private TableColumn<Item, BigDecimal> damagesColumn;
	@FXML
	private TableColumn<Item, BigDecimal> donationsColumn;
	
	private MenuBar menuBar;
	private Store store;
	private ObservableList<Item> inventory = FXCollections.observableArrayList();
	
	
	public TableController(Store store) {
		this.store = store;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// menuBar = AppController.getInstance().getAppMenuBar().getMenuBar();
		// pane.setTop(menuBar);
		
		
		/*
		 * TODO: Redo all of this to fit new project
		 * 
		inventory.addAll(store.getInventory());
		idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
		unitsColumn.setCellValueFactory(new PropertyValueFactory<>("units"));
		purchasesColumn.setCellValueFactory(new PropertyValueFactory<>("purchases"));
		salesColumn.setCellValueFactory(new PropertyValueFactory<>("sales"));
		markdownColumn.setCellValueFactory(new PropertyValueFactory<>("markdown"));
		damagesColumn.setCellValueFactory(new PropertyValueFactory<>("damages"));
		donationsColumn.setCellValueFactory(new PropertyValueFactory<>("donations"));
		
		itemTable.setItems(inventory);
		*/
		
	}

}
