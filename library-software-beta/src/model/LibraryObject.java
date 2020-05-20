package model;

public class LibraryObject {
	
	//attributes
	
	private String code;
	
	//relations
	
	private LibraryObject father;
	private LibraryObject right;
	private LibraryObject left;
	
	//methods
	
	public LibraryObject(String c) {
		code = c;
	}

	public LibraryObject getFather() {
		return father;
	}

	public void setFather(LibraryObject father) {
		this.father = father;
	}

	public LibraryObject getRight() {
		return right;
	}

	public void setRight(LibraryObject right) {
		this.right = right;
	}

	public LibraryObject getLeft() {
		return left;
	}

	public void setLeft(LibraryObject left) {
		this.left = left;
	}

	public String getCode() {
		return code;
	}
	
	
}
