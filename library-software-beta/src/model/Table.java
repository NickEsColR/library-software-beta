package model;

import java.util.ArrayList;

public class Table extends LibraryObject {
	
	//relations
	
	private ArrayList<Chair> chairs;
	
	//methods
	
	public Table(String c) {
		super(c);
		chairs = new ArrayList<Chair>();
	}
	
	public ArrayList<Chair> getChairs(){
		return chairs;
	}
	
	public void addChair(Chair c) {
		chairs.add(c);
	}
	
	public int chairsAmount() {
		return chairs.size();
	}
}
