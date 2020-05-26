package model;

public class Magazine extends Book {
	
	//attributes
	
	private String type;
 
	//methods

	public Magazine(String title, String author, String code,String gender, String dateOfPublication, int edition,
			String ageRestriction, String type) {
		super(title, author, code, gender, dateOfPublication, edition, ageRestriction);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
