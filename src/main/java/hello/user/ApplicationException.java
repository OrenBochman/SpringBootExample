package hello.user;

public class ApplicationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8200446355959793759L;
	
	public ApplicationException(String msg) {
		super(msg);
	}

	public ApplicationException(String msg,Exception e) {
		super(msg,e);
	}
	
	enum DB {
		
	}
}
