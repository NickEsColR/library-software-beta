package customException;

public class NoChairException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoChairException(String code) {
		super("the chair with code "+code+" doesn't exist");
	}
}
