public class NoRelatedTagException extends Exception {
    
    public NoRelatedTagException() {
	super();
    }
    
    public NoRelatedTagException(String message) {
	super(message);
    }
    
    public NoRelatedTagException(String message, Throwable cause) {
	super(message, cause);
    }
    
    public NoRelatedTagException(String m, Throwable c, boolean supr, boolean wST) {
	super(m,c,supr,wST);
    }
    
    public NoRelatedTagException(Throwable cause) {
	super(cause);
    }
}