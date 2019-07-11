package ank.hao.scheduler.core.exception;

public class UnauthorizedAccessException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5385545537061913512L;

	/**
	 * 
	 * @param errorMessage
	 *            异常信息，系统日志;
	 * @param frontEndMessage
	 *            需要前端提醒给客户的信息
	 */
	public UnauthorizedAccessException(String errorMessage, String frontEndMessage) {
		super(errorMessage, frontEndMessage);
	}

	/**
	 * 
	 * @param errorMessage
	 *            异常信息，系统日志;
	 * @param cause
	 */
	public UnauthorizedAccessException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}

	/**
	 * 
	 * @param errorMessage
	 *            异常信息，系统日志;
	 * @param frontEndMessage
	 *            需要前端提醒给客户的信息
	 * @param cause
	 */
	public UnauthorizedAccessException(String errorMessage, String frontEndMessage, Throwable cause) {
		super(errorMessage, frontEndMessage, cause);
	}

	/**
	 * 
	 * @param cause
	 */
	public UnauthorizedAccessException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * @param errorMessage
	 *            异常信息，系统日志;
	 */
	public UnauthorizedAccessException(String errorMessage) {
		super(errorMessage);
	}
}
