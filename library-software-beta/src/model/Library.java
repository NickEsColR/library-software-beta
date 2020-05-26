package model;

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
	
	
	public void leadBook(String cC, String cE, String cB) {
		
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
