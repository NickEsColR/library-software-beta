package customException;

public class NoBookException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoBookException(String title,String code) {
		super("the book "+title+" with code "+code+" doesn't exist");
	}
}
