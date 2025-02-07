package thread;

import model.Client;
import model.Library;

public class SearchClientThread extends Thread {
	private Library library;
	private String numID;
	private Client client;
	public SearchClientThread(Library library, String id) {
		this.library = library;
		numID = id;
	}
	@Override
	public void run() {
		client = library.searchClient(numID);
	}
	public Client getClient() {
		return client;
	}
}
