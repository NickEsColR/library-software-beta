package model;

public class Shelf implements KeepLimitBook{
	
	//constant
	
	public static int MAX_BOOK = 100;
	
	//attributes
	
	private String code;
	
	//relations
	
	private Book[] books;
	private Shelf father;
	private Shelf right;
	private Shelf left;
	
	//methods
	
	public Shelf(String c) {
		code = c;
		books = new Book[MAX_BOOK];
	}
	
	public String getCode() {
		return code;
	}
	
	public Shelf getFather() {
		return father;
	}

	public void setFather(Shelf father) {
		this.father = father;
	}

	public Shelf getRight() {
		return right;
	}

	public void setRight(Shelf right) {
		this.right = right;
	}

	public Shelf getLeft() {
		return left;
	}

	public void setLeft(Shelf left) {
		this.left = left;
	}
	
	public Book[] getBooks() {
		return books;
	}
	
	public void addBook(int pos, Book b) {
		books[pos] = b;
	}
	
	public boolean searchBook() {
		return false;
	}

	@Override
	public boolean canAddBook() {
		// TODO Auto-generated method stub
		return false;
	}
}
