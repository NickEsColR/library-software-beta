package model;

public class Person {

	//attributes
	
	private String name;
	private String lastName;
	private String typeID;
	private String NumID;
	
	//relations 
	
	private Person next;
	private Person prev;
	
	//methods
	public Person(String name, String lastName, String typeID, String numID) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.typeID = typeID;
		NumID = numID;
	}
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
	public String getTypeID() {
		return typeID;
	}
	public String getNumID() {
		return NumID;
	}
	public Person getNext() {
		return next;
	}
	public void setNext(Person next) {
		this.next = next;
	}
	public Person getPrev() {
		return prev;
	}
	public void setPrev(Person prev) {
		this.prev = prev;
	}
	
	
	
}
