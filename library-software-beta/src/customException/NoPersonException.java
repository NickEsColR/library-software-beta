package customException;

public class NoPersonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoPersonException(String name, String code) {
		super("the "+name +" whit id "+code+" doesn't exist"  );
	}
}
