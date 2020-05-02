package ui;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.*;
public class LibraryGUI {
	private Library library;
	@FXML
    private BorderPane mainPanel;
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtCode;

    @FXML
    private Label labMsg;

    @FXML
    void logIn(ActionEvent event) throws InterruptedException, IOException {
    	if(txtName.getText().equalsIgnoreCase("admin") && txtCode.getText().equalsIgnoreCase("admin")) {
    		labMsg.setText("ingreso exitoso");
    		Thread.sleep(100);
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-employee.fxml"));
   		 	fxmlLoader.setController(this);    	
   		 	BorderPane menuPane = fxmlLoader.load();	
   		 	mainPanel.getChildren().clear();
   		 	mainPanel.setCenter(menuPane);
    	}
    }
	public LibraryGUI(Library l)  {
		library = l;
	}
	
	public void openMenu() throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
	}
    @FXML
    void showChairsAmount(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chairs-number.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }

    @FXML
    void showLogInMenu(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("log-in.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }

    @FXML
    void showSearchBookMenu(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("search-book.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }

    @FXML
    void showTableChairsMenu(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("search-table-chairs.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void backMenu(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void logOut(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    
    @FXML
    void showAddBook(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-book.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void addBook(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-employee.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void showAddClient(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-client.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void addClient(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-employee.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void showAddEmployee(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-employee.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void addEmployee(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-employee.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void showAddMagazine(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-magazine.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void addMagazine(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-employee.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void showAddShelf(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-shelf.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void addShelf(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-employee.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void showLeadBook(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("lead-book.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void leadBook(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-employee.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void showRemoveBook(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("remove-book.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void removeBook(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-employee.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void showRemoveClient(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("remove-client.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void removeClient(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-employee.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void showRemoveEmployee(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("remove-employee.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void removeEmployee(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-employee.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void showRemoveShelf(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("remove-shelf.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    
    @FXML
    void removeShelf(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-employee.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
   
}
