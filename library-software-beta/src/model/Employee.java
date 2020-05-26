package model;

public class Employee extends Person implements PostRestriction{
	
	//attributes
	
	private String post;
	private int leadBooks;

	//methods
	
	public Employee(String name, String lastName, String typeID, String numID, String post) {
		super(name, lastName, typeID, numID);
		this.post = post;
		leadBooks = 0;
	}

	public String getPost() {
		return post;
	}

	public int getLeadBooks() {
		return leadBooks;
	}
	
	public void addLeadBook() {
		leadBooks++;
	}

	@Override
	public boolean postRestriction() {
		return post.equals("admin") ? true : false;
	}
	
}
