package ui;
import java.io.IOException;

import customException.NoBookException;
import customException.NoLeadException;
import customException.NoPersonException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.*;
public class LibraryGUI {
		
	private Library library;
 

    @FXML
    private Label labChairsAmount;
    @FXML
    private TextField txtShelfNumber;
	@FXML
    private BorderPane mainPanel;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtIdType;

    @FXML
    private TextField txtIdNum;

    @FXML
    private TextField txtPost;
    @FXML
    private TextField txtCode;

    @FXML
    private Label labMsg;
    
    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtEdition;

    @FXML
    private TextField txtYear;

    @FXML
    private TextField txtMonth;

    @FXML
    private TextField txtDay;
    @FXML
    private TextField txtAgeRestriction;

    @FXML
    private TextField txtType;
    @FXML
    private TextField txtSubject;

    @FXML
    private TextArea txtSinopsis;

    @FXML
    private TextField txtIsAcademic;
    @FXML
    private TextField txtChairCode;

    @FXML
    private TextField txtTableCode;
    @FXML
    private TextField txtIdNumBook;

    @FXML
    private TextField txtIdNumEmployee;

    @FXML
    private TextField txtIdNumClient;


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
    	}else {
    		labMsg.setText("nombre o codigo incorrecto");
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
    void searchBook(ActionEvent event) {
    	if(txtTitle.getText().trim().isEmpty()) {
    		labMsg.setText("digite el nombre del libro o revista");
    	}else {
    		Book b;
			try {
				b = library.searchBookForName(txtTitle.getText());
				txtCode.setText(b.getCode());
			} catch (NoBookException e) {
				labMsg.setText(e.getMessage());
			}
    	}
    }
    @FXML
    void showTableChairsMenu(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("search-table-chairs.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
		 labChairsAmount.setText(Integer.toString(library.peopleCanSit()));
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
    	if(txtTitle.getText().trim().isEmpty()|txtAutor.getText().trim().isEmpty()|txtGender.getText().trim().isEmpty()|
    			txtEdition.getText().trim().isEmpty()|txtYear.getText().trim().isEmpty()|txtMonth.getText().trim().isEmpty()|
    			txtDay.getText().trim().isEmpty()|txtCode.getText().trim().isEmpty()|txtAgeRestriction.getText().trim().isEmpty()) {
    		labMsg.setText("Celdas vacias, �por favor llene todas las celdas");
    	}else {
    		try {
    			String title = txtTitle.getText();
    			String author = txtAutor.getText();
    			String gender = txtGender.getText();
    			int edition = Integer.parseInt(txtEdition.getText());
    			String date = txtDay.getText()+ "/"+txtMonth.getText()+"/"+txtYear.getText();
    			String code = txtCode.getText();
    			String age = txtAgeRestriction.getText();
    			if(txtIsAcademic.getText().equalsIgnoreCase("no")) {
    				library.addBook(title, author, code, gender, date,  edition,  age);    				
    			}else {
    				addAcademicBook(title, author, code, gender, date,  edition,  age);
    			}
    			backEmployeeMenu();
    		}catch(NumberFormatException e) {
    			labMsg.setText("La celda edicion,a�o mes y dia debe ser un numero entero, favor digitar un numero valido");
    		}
    	}
    	
    }
    
    public void addAcademicBook(String title, String author, String code,String gender, String dateOfPublication, int edition,
    		String ageRestriction) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("academic-book.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
		 if(txtSubject.getText().trim().isEmpty()||txtSinopsis.getText().trim().isEmpty()) {
			 labMsg.setText("Celdas vacias, �por favor llene todas las celdas");
		 }else {
			 String subject = txtSubject.getText();
			 String sinopsis = txtSinopsis.getText();
			 library.addAcademicBook(title, author, code, gender, dateOfPublication, edition, ageRestriction, subject, sinopsis);
		 }
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
    	if(txtName.getText().trim().isEmpty()|txtLastName.getText().trim().isEmpty()|txtIdType.getText().trim().isEmpty()|
    			txtIdNum.getText().trim().isEmpty()) {
    		labMsg.setText("Celdas vacias, �por favor llene todas las celdas");
    	}else {
    		String name = txtName.getText();
    		String lastName = txtLastName.getText();
    		String idType = txtIdType.getText();
    		String idNum = txtIdNum.getText();
    		library.addClient(name, lastName, idType, idNum);
    		backEmployeeMenu();
    	}
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
    	if(txtName.getText().trim().isEmpty()|txtLastName.getText().trim().isEmpty()|txtIdType.getText().trim().isEmpty()|
    			txtIdNum.getText().trim().isEmpty()|txtPost.getText().trim().isEmpty()) {
    		labMsg.setText("Celdas vacias, �por favor llene todas las celdas");
    	}else {
    		String name = txtName.getText();
    		String lastName = txtLastName.getText();
    		String idType = txtIdType.getText();
    		String idNum = txtIdNum.getText();
    		String post = txtPost.getText();
    		library.addEmployee(name, lastName, idType, idNum, post);
    		backEmployeeMenu();
    	}
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
    	if(txtTitle.getText().trim().isEmpty()|txtAutor.getText().trim().isEmpty()|txtGender.getText().trim().isEmpty()|
    			txtEdition.getText().trim().isEmpty()|txtYear.getText().trim().isEmpty()|txtMonth.getText().trim().isEmpty()|
    			txtDay.getText().trim().isEmpty()|txtCode.getText().trim().isEmpty()|txtAgeRestriction.getText().trim().isEmpty()|
    			txtType.getText().trim().isEmpty()) {
    		labMsg.setText("Celdas vacias, �por favor llene todas las celdas");
    	}else {
    		try {
    			String title = txtTitle.getText();
    			String author = txtAutor.getText();
    			String gender = txtGender.getText();
    			int edition = Integer.parseInt(txtEdition.getText());
    			String date = txtDay.getText()+ "/"+txtMonth.getText()+"/"+txtYear.getText();
    			String code = txtCode.getText();
    			String age = txtAgeRestriction.getText();
    			String type = txtType.getText();
    			library.addMagazine(title, author, code, gender, date,  edition,  age,type);
    			backEmployeeMenu();
    		}catch(NumberFormatException e) {
    			labMsg.setText("La celda edicion,a�o mes y dia debe ser un numero entero, favor digitar un numero valido");
    		}
    	}
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
       	if(txtCode.getText().trim().isEmpty()) {
    		labMsg.setText("la celda de # de identificacion esta vacia");
    	}else {
    		String code = txtCode.getText();
    		library.addShelf(code);
    		backEmployeeMenu();
    	}
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
    void leadBook(ActionEvent event) throws IOException, InterruptedException {
    	if(txtIdNumBook.getText().trim().isEmpty()|txtIdNumEmployee.getText().trim().isEmpty()|txtIdNumClient.getText().trim().isEmpty()) {
    		labMsg.setText("Celdas vacias, �por favor llene todas las celdas");
    	}else {
    		try {
				library.leadBook(txtIdNumClient.getText(), txtIdNumEmployee.getText(), txtIdNumBook.getText());
				backEmployeeMenu();
			} catch (NoPersonException | NoBookException | NoLeadException e) {
				labMsg.setText(e.getMessage());
			}
    	}
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
    
    @FXML
    void showAddChair(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-chair.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    
    @FXML
    void showAddTable(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-table.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }

    @FXML
    void addTable(ActionEvent event) throws IOException {
       	if(txtCode.getText().trim().isEmpty()) {
    		labMsg.setText("la celda de # de identificacion esta vacia");
    	}else {
    		String code = txtCode.getText();
    		library.addTable(code);
    		backEmployeeMenu();
    	}
    }
    @FXML
    void showAddChairToTable(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-chair-to-table.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void addChairToTable(ActionEvent event) {
    	library.addChairTable(txtChairCode.getText(), txtTableCode.getText());
    }
    @FXML
    void showRemoveChair(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("remove-chair.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void showRemoveTable(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("remove-table.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
    @FXML
    void showDeliverBook(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("deliver-book.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }

    @FXML
    void deliverBook(ActionEvent event) throws IOException {
    	if(txtIdNumBook.getText().trim().isEmpty()|txtIdNumEmployee.getText().trim().isEmpty()|txtIdNumClient.getText().trim().isEmpty()) {
    		labMsg.setText("Celdas vacias, �por favor llene todas las celdas");
    	}else {
    		try {
				library.deliverBookClient(txtIdNumClient.getText(), txtIdNumEmployee.getText(), txtIdNumBook.getText());
				backEmployeeMenu();
			} catch (NoPersonException | NoBookException e) {
				labMsg.setText(e.getMessage());
			}
    	}
    }
    @FXML
    void showUnban(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("unban.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }

    @FXML
    void addChair(ActionEvent event) throws IOException {
    	if(txtCode.getText().trim().isEmpty()) {
    		labMsg.setText("la celda de # de identificacion esta vacia");
    	}else {
    		String code = txtCode.getText();
    		library.addChair(code);
    		backEmployeeMenu();
    	}
    }
    public void backEmployeeMenu() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-employee.fxml"));
		 fxmlLoader.setController(this);    	
		 BorderPane menuPane = fxmlLoader.load();	
		 mainPanel.getChildren().clear();
		 mainPanel.setCenter(menuPane);
    }
}
