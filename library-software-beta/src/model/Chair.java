package model;

public class Chair extends LibraryObject {
	
	//attributes
	
	private boolean busy;
	
	//methods
	
	public Chair(String c) {
		super(c);
		busy = false;
	}

	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}
	
}
