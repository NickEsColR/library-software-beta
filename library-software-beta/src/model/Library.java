package model;

import customException.NoBookException;
import customException.NoLeadException;
import customException.NoPersonException;
import thread.SearchBookThread;
import thread.SearchClientThread;
import thread.SearchEmployeeThread;

public class Library {
	
	//attributes
	private int chairAmount;
	//relations
	private Book firstBook;
	private Person firstPerson;
	private Shelf rootShelf;
	private LibraryObject rootLibraryObject;
	
	public Library() {
		chairAmount = 0;
	}
	
	public void addEmployee(String name, String lastName, String typeID, String numID, String post) {
		Person newPer = new Employee(name, lastName, typeID, numID, post);
		
		if(firstPerson == null) {
			firstPerson = newPer;
		}else {
			
			Person current = firstPerson;
			while(current.getNext() != null ) {
				current = current.getNext();
			}
			
			current.setNext(newPer);
			current.getNext().setPrev(current);
			
		}
	}
	
	public void addClient(String name, String lastName, String typeID, String numID) {
		Person newCli = new Client(name, lastName, typeID, numID, false);
		
		if(firstPerson == null) {
			firstPerson = newCli;
		}else {
			
			Person current = firstPerson;
			while(current.getNext() != null ) {
				current = current.getNext();
			}
			
			current.setNext(newCli);
			current.getNext().setPrev(current);
			
		}
	}
	
	public void addBook(String title, String author, String code,String gender,String dateOfPublication, int edition, String ageRestriction) {
		Book newBoo = new Book(title, author, code, gender,dateOfPublication, edition, ageRestriction);
		
		if(firstBook == null) {
			firstBook = newBoo;
		}else {
			
			Book current = firstBook;
			while(current.getNext() != null ) {
				current = current.getNext();
			}
			
			current.setNext(newBoo);
			current.getNext().setPrev(current);
			
		}
	}
	
	public void addMagazine(String title, String author, String code, String gender,String dateOfPublication, int edition,
		String ageRestriction, String type) {
		Book newMag = new Magazine(title, author, code, gender,dateOfPublication, edition, ageRestriction, type);
		
		if(firstBook == null) {
			firstBook = newMag;
		}else {
			
			Book current = firstBook;
			while(current.getNext() != null ) {
				current = current.getNext();
			}
			
			current.setNext(newMag);
			current.getNext().setPrev(current);
			
		}

	}
	
	public void addAcademicBook(String title, String author, String code,String gender, String dateOfPublication, int edition,
		String ageRestriction, String subject, String sinopsis) {
		Book newAca = new AcademicBook(title, author, code, gender,dateOfPublication, edition, ageRestriction, subject, sinopsis);
		
		if(firstBook == null) {
			firstBook = newAca;
		}else {
			
			Book current = firstBook;
			while(current.getNext() != null ) {
				current = current.getNext();
			}
			
			current.setNext(newAca);
			current.getNext().setPrev(current);
			
		}
	}
	
	public void addChair(String c) {
		LibraryObject newShelf = new Chair(c);
		
		if(rootLibraryObject == null) {
			rootLibraryObject = newShelf;
		}else {
			
			LibraryObject current = rootLibraryObject;
			LibraryObject father;
			
			while(true) {
				father = current;
				if(c.compareTo(current.getCode()) < 0) {
					current = current.getLeft();
					if(current == null) {
						father.setLeft(newShelf);
					}
				}else {
					
					current = current.getRight();
					if(current == null) {
						father.setRight(newShelf);
					}
					
				}
			}		
		}
		chairAmount++;
	}
	
	public void addTable(String c) {
		LibraryObject newShelf = new Table(c);
		
		if(rootLibraryObject == null) {
			rootLibraryObject = newShelf;
		}else {
			
			LibraryObject current = rootLibraryObject;
			LibraryObject father;
			
			while(true) {
				father = current;
				if(c.compareTo(current.getCode()) < 0) {
					current = current.getLeft();
					if(current == null) {
						father.setLeft(newShelf);
						return;
					}
				}else {
					
					current = current.getRight();
					if(current == null) {
						father.setRight(newShelf);
						return;
					}
					
				}
			}
			
		}
	}
	
	public void addShelf(String c) {
Shelf newShelf = new Shelf(c);
		
		if(rootShelf == null) {
			rootShelf = newShelf;
		}else {
			
			Shelf current = rootShelf;
			Shelf father;
			
			while(true) {
				father = current;
				if(c.compareTo(current.getCode()) < 0) {
					current = current.getLeft();
					if(current == null) {
						father.setLeft(newShelf);
						return;
					}
				}else {
					
					current = current.getRight();
					if(current == null) {
						father.setRight(newShelf);
						return;
					}
					
				}
			}
			
		}
	}
	public void removeChair(String c) {
		LibraryObject eliminate = searchChair(c);
		if(eliminate != null) {
			if(eliminate == rootLibraryObject) {
				removeLibraryObjectFather();
			}else if(eliminate.getLeft() == null && eliminate.getRight() == null) {
				
				removeLibraryObjectCase1(eliminate);
				
			}else if(eliminate.getLeft() != null ) {
				
				if(eliminate.getRight() == null) {
					
					removeLibraryObjectCase2(eliminate);
					
				}
				
			}else if(eliminate.getRight() != null){
				
				if(eliminate.getLeft() == null) {
					
					removeLibraryObjectCase2(eliminate);
					
				}
				
			}else {
				
				removeLibraryObjectCase3(eliminate);
				
			}	
		}
	}
	
	public void removeTable(String c) {	
		LibraryObject eliminate = searchTable(c);
		if(eliminate != null) {
			if(eliminate == rootLibraryObject) {
				removeLibraryObjectFather();
			}else if(eliminate.getLeft() == null && eliminate.getRight() == null) {
				
				removeLibraryObjectCase1(eliminate);
				
			}else if(eliminate.getLeft() != null ) {
				
				if(eliminate.getRight() == null) {
					
					removeLibraryObjectCase2(eliminate);
					
				}
				
			}else if(eliminate.getRight() != null){
				
				if(eliminate.getLeft() == null) {
					
					removeLibraryObjectCase2(eliminate);
					
				}
				
			}else {
				
				removeLibraryObjectCase3(eliminate);
				
			}	
		}
	}
	public void removeLibraryObjectFather() {
		LibraryObject replace = rootLibraryObject;
		if(rootLibraryObject.getLeft()!=null) {
			replace = replace.getLeft();
			while(replace.getRight() !=null) {
				replace = replace.getRight();
				
			}
			rootLibraryObject.getLeft().setFather(replace);
			replace.getFather().setRight(replace.getLeft());
			replace.setLeft(rootLibraryObject.getLeft());
			if(rootLibraryObject.getRight()!=null) {
				rootLibraryObject.getRight().setFather(replace);
				replace.setRight(rootLibraryObject.getRight());
			}
		}else if(rootLibraryObject.getRight()!=null){
			replace = replace.getRight();
			while(replace.getLeft() !=null) {
				replace = replace.getLeft();
			}
			replace.getFather().setRight(replace.getLeft());
			rootLibraryObject.getRight().setFather(replace);
			replace.setRight(rootLibraryObject.getRight());
		}else {
			rootLibraryObject = null;
		}
	}
	public void removeLibraryObjectCase1(LibraryObject eliminate) {
		LibraryObject father = eliminate.getFather();
		
		if(father.getLeft().equals(eliminate)) {
			father.setLeft(null);
		}else {
			father.setRight(null);
		}
	}
	public void removeLibraryObjectCase2(LibraryObject eliminate) {
		LibraryObject father = eliminate.getFather();
		
		if(eliminate.getLeft() == null) {
			
			LibraryObject hijo = eliminate.getRight();
			
			father.setRight(hijo);
			hijo.setFather(father);
			
		}else {
			
			LibraryObject hijo = eliminate.getLeft();
			
			father.setLeft(hijo);
			hijo.setFather(father);
		}
	}
	public void removeLibraryObjectCase3(LibraryObject eliminate) {
		LibraryObject replace = eliminate;

		replace = replace.getLeft();
		while(replace.getRight() !=null) {
			replace = replace.getRight();
			
		}
		eliminate.getLeft().setFather(replace);
		replace.getFather().setRight(replace.getLeft());
		replace.setLeft(eliminate.getLeft());
		eliminate.getRight().setFather(replace);
		replace.setRight(eliminate.getRight());
		if(eliminate.getFather().getLeft().equals(eliminate)) {
			eliminate.getFather().setLeft(replace);
		}else {
			eliminate.getFather().setRight(replace);
		}	
	}
public void removeShelf(String code) {
		
	Shelf eliminate = searchShelf(code);
		
		if(eliminate != null) {
			if(eliminate == rootShelf) {
				removeFather();
			}else if(eliminate.getLeft() == null && eliminate.getRight() == null) {
				
				removeCase1(eliminate);
				
			}else if(eliminate.getLeft() != null ) {
				
				if(eliminate.getRight() == null) {
					
					removeCase2(eliminate);
					
				}
				
			}else if(eliminate.getRight() != null){
				
				if(eliminate.getLeft() == null) {
					
					removeCase2(eliminate);
					
				}
				
			}else {
				
				removeCase3(eliminate);
				
			}	
		}
		
	}
	private void removeCase1(Shelf eliminate) {
	
		Shelf father = eliminate.getFather();
		
			if(father.getLeft().equals(eliminate)) {
				father.setLeft(null);
			}else {
				father.setRight(null);
			}
		
	}
	private void removeCase2(Shelf eliminate) {
			
			Shelf father = eliminate.getFather();
				
			if(eliminate.getLeft() == null) {
				
				Shelf hijo = eliminate.getRight();
				
				father.setRight(hijo);
				hijo.setFather(father);
				
			}else {
				
				Shelf hijo = eliminate.getLeft();
				
				father.setLeft(hijo);
				hijo.setFather(father);
			}
			
		
	}

	private void removeCase3(Shelf eliminate) {
		Shelf replace = eliminate;

			replace = replace.getLeft();
			while(replace.getRight() !=null) {
				replace = replace.getRight();
				
			}
			eliminate.getLeft().setFather(replace);
			replace.getFather().setRight(replace.getLeft());
			replace.setLeft(eliminate.getLeft());
			eliminate.getRight().setFather(replace);
			replace.setRight(eliminate.getRight());
			if(eliminate.getFather().getLeft().equals(eliminate)) {
				eliminate.getFather().setLeft(replace);
			}else {
				eliminate.getFather().setRight(replace);
			}	
	}
	
	private void removeFather() {
		Shelf replace = rootShelf;
		if(rootShelf.getLeft()!=null) {
			replace = replace.getLeft();
			while(replace.getRight() !=null) {
				replace = replace.getRight();
				
			}
			rootShelf.getLeft().setFather(replace);
			replace.getFather().setRight(replace.getLeft());
			replace.setLeft(rootShelf.getLeft());
			if(rootShelf.getRight()!=null) {
				rootShelf.getRight().setFather(replace);
				replace.setRight(rootShelf.getRight());
			}
		}else if(rootShelf.getRight()!=null){
			replace = replace.getRight();
			while(replace.getLeft() !=null) {
				replace = replace.getLeft();
			}
			replace.getFather().setRight(replace.getLeft());
			rootShelf.getRight().setFather(replace);
			replace.setRight(rootShelf.getRight());
		}else {
			rootShelf = null;
		}
	}
	public void removeEmployee(String numID) {
		
		Person search = searchEmployee(numID);
		
		if(search != null) {
			
			if(firstPerson instanceof Employee && search.equals(firstPerson)) {
				
				firstBook = null;
					
			}else if(search.getNext() != null) {
				
				Person prev = search.getPrev();
				prev.setNext(search.getNext());
				search.getNext().setPrev(prev);
				search.setNext(null);
				search.setPrev(null);
			}else {
				
				Person prev = search.getPrev();
				
				prev.setNext(null);					
				search.setPrev(null);
				
			}

			
		}
		
	}
	
	public void removeClient(String numID) {
		
		Person search = searchClient(numID);
		
		
		if(search != null) {
			
			if(firstPerson instanceof Client && search.equals(firstPerson)) {
				
				firstBook = null;
					
			}else if(search.getNext() != null) {
				
				Person prev = search.getPrev();
				prev.setNext(search.getNext());
				search.getNext().setPrev(prev);
				search.setNext(null);
				search.setPrev(null);
			}else {
				
				Person prev = search.getPrev();
				
				prev.setNext(null);					
				search.setPrev(null);
				
			}

			
		}
		
	}
	
	public void removeBook(String code) {
		Book search = searchBookForCode(code);
		
		if(search != null) {
			
			if(search.equals(firstPerson)) {
				
				firstBook = null;
					
			}else if(search.getNext() != null) {
				
				Book prev = search.getPrev();
				
				prev.setNext(search.getNext());
				search.getNext().setPrev(prev);
				search.setNext(null);
				search.setPrev(null);
				
			}else {
				
				Book prev = search.getPrev();
				
				prev.setNext(null);					
				search.setPrev(null);
				
			}

			
		}
	}
	public Client getSearchClient(Client c) {
		return c;
	}
	
	public void leadBook(String cC, String cE, String cB) throws NoPersonException,NoBookException, NoLeadException, InterruptedException{
		SearchClientThread scThread = new SearchClientThread(this,cC);
		SearchEmployeeThread seThread = new SearchEmployeeThread(this,cE);
		SearchBookThread sbThread = new SearchBookThread(this,cB);
		scThread.start();
		seThread.start();
		sbThread.start();
		scThread.join();
		seThread.join();
		sbThread.join();
		Client leadC=scThread.getClient();
		Employee leadE = seThread.getEmployee();
		Book leadB = sbThread.getBook();  
		if(leadC == null) {
			throw new NoPersonException("cliente",cC);
		}else if(leadE==null) {
			throw new NoPersonException("empleado",cE);
		}else if(leadB == null) {
			throw new NoBookException("",cB);
		}else {
			if(leadC.canAddBook()) {
				leadE.addLeadBook();
				leadC.leadBook();
			}else {
				throw new NoLeadException();
			}
		}
		
	}
	
public Employee searchEmployee(String numID) {
		
		Person current = firstPerson;
		
		return searchEmployee(current, numID);
		
	}
	
 	private Employee searchEmployee(Person current, String numID) {
		
 		Employee search = null;
 		
 		if(current != null) {
			
			if(current.getNumID().equals(numID) && (current instanceof Employee)) {
				
				search =  (Employee) current;
				
			}else {
				
				current = current.getNext();
				
				search = searchEmployee(current,  numID);
				
			}
			
		}else {
			search = null;
		}
		
		return search;
		
	}
	
	public Client searchClient (String numID) {
		
		Person current = firstPerson;
		
		return searchClient(current, numID);
		
	}
	
	private Client searchClient(Person current, String numID) {
		
		Client search;
 		
 		if(current != null) {
			
			if(current.getNumID().equals(numID) && (current instanceof Client)) {
				
				search =  (Client) current;
				
			}else {
				
				current = current.getNext();
				
				search = searchClient(current, numID);
				
			}
			
		}else {
			search = null;
		}
		
		return search;
		
	}
	
	public Book searchBookForCode(String code) {
	
		Book current = firstBook;
		
		return searchBookForCode(current, code);
		
	}
	
	private Book searchBookForCode(Book current, String code) {
	
		Book search;
 		
 		if(current != null) {
			
			if(current.getCode().equals(code)) {
				search =  current;
			}else {
				
				current = current.getNext();
				
				search = searchBookForCode(current, code);
				
			}
			
		}else {
			search = null;
		}
		
		return search;
		
	}	
	
	public Book searchBookForName(String name)throws NoBookException {
		
		Book current = searchBookForName(firstBook, name);
		if(current == null) {
			throw new NoBookException(name,"");
		}
		return current;
		
	}
	
	private Book searchBookForName(Book current, String name) {
	
		Book search;
 		
 		if(current != null) {
			
			if(current.getCode().equals(name)) {
				search =  current;
			}else {
				
				current = current.getNext();
				
				search = searchBookForName(current, name);
				
			}
			
		}else {
			search = null;
		}
		
		return search;
		
	}	

	public Chair searchChair(String code) {
	
		LibraryObject current = rootLibraryObject;
		 
		return searchChair(current, code);
		
	}
	
	private Chair searchChair(LibraryObject current, String code) {
		
		Chair search;

		if(current != null) {
			
			if(current.getCode().equals(code) && (current instanceof Chair)) {
				
				search = (Chair) current;
				

			}else {
				
				if(code.compareTo(current.getCode()) < 0) {
					 current = current.getLeft();
					 
				 }else {
					 current = current.getRight();
				 }
				
				search = searchChair(current, code);
				
			}
			
		}else {
			
			search = null;
			
		}
		
		return search;
		
	}
	
	public Table searchTable(String code) {
	
		LibraryObject current = rootLibraryObject;
		 
		return searchTable(current, code);
		
	}
	
	private Table searchTable(LibraryObject current, String code) {
		
		Table search;

		if(current != null) {
			
			if(current.getCode().equals(code) && (current instanceof Table)) {
				
				search = (Table) current;
				

			}else {
				
				if(code.compareTo(current.getCode()) < 0) {
					 current = current.getLeft();
					 
				 }else {
					 current = current.getRight();
				 }
				
				search = searchTable(current, code);
				
			}
			
		}else {
			
			search = null;
			
		}
		
		return search;
		
	}
	
	
	public Shelf searchShelf(String code) {
	
		Shelf current = rootShelf;
		 
		return searchShelf(current, code);
		
	}
	
	
	public Shelf searchShelf(Shelf current, String code) {
		
		Shelf search;
		
		
		if(current != null) {
			
			if(current.getCode().equals(code)) {
				
				search = current;
				
			}else {
				
				if(code.compareTo(current.getCode()) < 0) {
					 current = current.getLeft();
					 
				 }else {
					 current = current.getRight();
				 }
				
				search = searchShelf(current, code);
				
			}
			
		}else {
			
			search = null;
			
		}
		
		return search;
		
	}
	public Book getFirstBook() {
		return firstBook;
	}

	public void setFirstBook(Book firstBook) {
		this.firstBook = firstBook;
	}

	public Person getFirstPerson() {
		return firstPerson;
	}

	public void setFirstPerson(Person firstPerson) {
		this.firstPerson = firstPerson;
	}

	public Shelf getRootShelf() {
		return rootShelf;
	}

	public void setRootShelf(Shelf rootShelf) {
		this.rootShelf = rootShelf;
	}

	public LibraryObject getRootLibraryObject() {
		return rootLibraryObject;
	}

	public void setRootLibraryObject(LibraryObject rootLibraryObject) {
		this.rootLibraryObject = rootLibraryObject;
	}
	public void addChairTable(String codeChair, String codeTable) {
		
		Chair c = searchChair(codeChair);
		Table t = searchTable(codeTable);
		if(c != null && t != null) {
			
			t.addChair(c);
			
		}
		
	}
	
	public void deliverBookClient(String idClient, String idEmployee, String codeBook) throws NoBookException, NoPersonException {
		
		Book b = searchBookForCode(codeBook);
		Client c = searchClient(idClient);
		Employee e = searchEmployee(idEmployee);
		
		if(b != null && c != null && e != null) {
			c.deliverBook();
		}else if(b == null) {
			throw new NoBookException("",codeBook);
		}else if(c == null) {
			throw new NoPersonException("cliente",idClient);
		}else if(e == null) {
			throw new NoPersonException("empleado",idEmployee);
		}
		
		
	}
	
	public int peopleCanSit() {
		
		return chairAmount;
		
	}

}
