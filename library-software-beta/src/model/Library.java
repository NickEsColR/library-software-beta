package model;

public class Library {
	
	//relations
	private Book firstBook;
	private Person firstPerson;
	private Shelf rootShelf;
	private LibraryObject rootLibraryObject;
	
	public Library() {
		
	}
	
	public void addEmployee(String name, String lastName, String typeID, String numID, String post, int leadBooks) {
		
	}
	
	public void addClient(String name, String lastName, String typeID, String numID, boolean ban) {
		
	}
	
	public void addBook(String title, String author, String code, String dateOfPublication, int edition, String ageRestriction) {
		
	}
	
	public void addMagazine(String title, String author, String code, String dateOfPublication, int edition,
			String ageRestriction, String type) {
		
	}
	
	public void addAcademicBook(String title, String author, String code, String dateOfPublication, int edition,
			String ageRestriction, String subject, String sinopsis) {
		
	}
	
	public void addChair(String c, boolean b) {
		
	}
	
	public void addTable(String c) {
		
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
