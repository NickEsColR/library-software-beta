package thread;
import model.Employee;
import model.Library;

public class SearchEmployeeThread extends Thread {
	private Library library;
	private String numID;
	private Employee employee;
	public SearchEmployeeThread(Library library, String id) {
		this.library = library;
		numID = id;
	}
	@Override
	public void run() {
		employee = library.searchEmployee(numID);
	}
	public Employee getEmployee() {
		return employee;
	}
}
