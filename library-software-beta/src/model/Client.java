package model;

public class Client extends Person implements KeepLimitBook {
	
	//constants
	
	public static int MAX_LEAD_BOOKS = 10;
	
	//attributes 
	private boolean ban;

	//methods
	
	public Client(String name, String lastName, String typeID, String numID, boolean ban) {
		super(name, lastName, typeID, numID);
		this.ban = ban;
	}
	
	public boolean isBan() {
		return ban;
	}

	public void setBan(boolean ban) {
		this.ban = ban;
	}

	@Override
	public boolean canAddBook() {
		// TODO Auto-generated method stub
		return false;
	}

}
