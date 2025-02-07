package model;

public class Book {
	
	//attributes
	
	private String title;
	private String author;
	private String code;
	private String gender;
	private String dateOfPublication;
	private int edition;
	private String ageRestriction;
	
	//relations
	
	private Book next;
	private Book prev;
	
	//methods
	
	public Book(String title, String author, String code, String gender,String dateOfPublication, int edition, String ageRestriction) {
		
		this.title = title;
		this.author = author;
		this.code = code;
		this.setGender(gender);
		this.dateOfPublication = dateOfPublication;
		this.edition = edition;
		this.ageRestriction = ageRestriction;
	}

	public Book getNext() {
		return next;
	}

	public void setNext(Book next) {
		this.next = next;
	}

	public Book getPrev() {
		return prev;
	}

	public void setPrev(Book prev) {
		this.prev = prev;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getCode() {
		return code;
	}

	public String getDateOfPublication() {
		return dateOfPublication;
	}

	public int getEdition() {
		return edition;
	}

	public String getAgeRestriction() {
		return ageRestriction;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
