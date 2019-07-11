package ank.hao.scheduler.core.exception;

public class NoRollBackException extends Exception {


    private static final long serialVersionUID = -5176654175352604586L;


    public NoRollBackException(Throwable cause) {
        super(cause);
    }


    public NoRollBackException(String errorMessage) {
        super(errorMessage);
    }


    public NoRollBackException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }


}
