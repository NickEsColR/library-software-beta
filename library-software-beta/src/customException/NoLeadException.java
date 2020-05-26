package customException;

public class NoLeadException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoLeadException() {
		super("no se puede prestar el libro, el cliente ya a superado la cantidad maxima");
	}
}
