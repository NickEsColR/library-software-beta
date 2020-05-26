package model;

public class AcademicBook extends Book {
	
	//attributes
	
	private String subject;
	private String sinopsis;
	
	//methods
	
	public AcademicBook(String title, String author, String code,String gender, String dateOfPublication, int edition,
			String ageRestriction, String subject, String sinopsis) {
		super(title, author, code, gender, dateOfPublication, edition, ageRestriction);
		this.subject = subject;
		this.sinopsis = sinopsis;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	
	
}
