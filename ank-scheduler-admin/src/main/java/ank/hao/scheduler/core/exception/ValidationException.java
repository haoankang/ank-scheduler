package ank.hao.scheduler.core.exception;

public class ValidationException extends Exception {
    private static final long serialVersionUID = -5176651175352604586L;

    public ValidationException(Throwable cause) {
        super(cause);
    }


    public ValidationException(String errorMessage) {
        super(errorMessage);
    }


    public ValidationException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
