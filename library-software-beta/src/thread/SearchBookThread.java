package thread;
import model.Library;
import model.Book;
public class SearchBookThread extends Thread {
	private Library library;
	private String numID;
	private Book book;
	public SearchBookThread(Library library, String id) {
		this.library = library;
		numID = id;
	}
	@Override
	public void run() {
		book = library.searchBookForCode(numID);
	}
	public Book getBook() {
		return book;
	}
}
