package model;

import customException.NoBookException;
import customException.NoLeadException;
import customException.NoPersonException;
import thread.SearchBookThread;
import thread.SearchClientThread;
import thread.SearchEmployeeThread;

public class Library {
	
	//relations
	private Book firstBook;
	private Person firstPerson;
	private Shelf rootShelf;
	private LibraryObject rootLibraryObject;
	
	public Library() {
		
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
		
	}
	
	public void removeTable(String c) {
		
	}
	
	public void removePerson(String numID) {
		
	}
	
	public void removeBook(String code) {
		
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
	
	public Book searchBookForName(String name) {
		
		Book current = firstBook;
		
		return searchBookForName(current, name);
		
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
	
	
}
