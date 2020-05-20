package model;

public class Chair extends LibraryObject {
	
	//attributes
	
	private boolean busy;
	
	//methods
	
	public Chair(String c, boolean b) {
		super(c);
		busy = b;
	}

	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}
	
}
