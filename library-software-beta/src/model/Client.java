package model;

public class Client extends Person implements KeepLimitBook {
	
	//constants
	
	public static int MAX_LEAD_BOOKS = 3;
	
	//attributes 
	private boolean ban;
	private int leadBooks; 

	//methods
	
	public Client(String name, String lastName, String typeID, String numID, boolean ban) {
		super(name, lastName, typeID, numID);
		this.ban = ban;
		leadBooks = 0;
	}
	
	public boolean isBan() {
		return ban;
	}

	public void setBan(boolean ban) {
		this.ban = ban;
	}

	@Override
	public boolean canAddBook() {
		return leadBooks <= Client.MAX_LEAD_BOOKS? true : false;
	}

	public int getLeadBooks() {
		return leadBooks;
	}
	
	public void leadBook() {
		leadBooks++;
	}
	public void deliverBook() {
		leadBooks--;
	}
}
