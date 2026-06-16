package reptiles;

public class InvalidNumberException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidNumberException() {
		super();
		
	}

	public InvalidNumberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public InvalidNumberException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidNumberException(String message) {
		super(message);
		
	}

	public InvalidNumberException(Throwable cause) {
		super(cause);
		
	}
	
}
