package ank.hao.scheduler.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.nio.charset.MalformedInputException;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice(
        basePackages = {"cn.com.bsfit"}
)
public class GlobalControllerExceptionHandler {

    public static Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    private final String TIMESTAMP = "timestamp";

    private final String STATUS = "status";

    private final String ERROR = "error";

    private final String EXCEPTION = "exception";

    private final String MESSAGE = "message";

    private final String TRACEINFO = "traceInfo";

    @SuppressWarnings("unused")
    private final String PATH = "path";

    private final String FRONT_END_MESSAGE = "frontEndMessage";

    private final String VALIDATION_MESSAGE = "validationMessage";

    @ExceptionHandler({InvalidRequestParamException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    HashMap<String, Object> handleInvalidRequestException(InvalidRequestParamException e) {
        logger.warn(e.getMessage(), e);
        HashMap<String, Object> errorResp = getResponse(HttpStatus.BAD_REQUEST, e);
        return errorResp;
    }


    @ExceptionHandler({MalformedInputException.class})
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    HashMap<String, Object> handleMalformedInputException(MalformedInputException e) {
        logger.warn(e.getMessage(), e);
        HashMap<String, Object> errorResp = getResponse(HttpStatus.BAD_REQUEST, new InvalidRequestParamException
                ("该文件不能是UTF-8编码，请选择GBK编码"));
        return errorResp;
    }

    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    HashMap<String, Object> handleInternalServerException(InternalServerException e) {
        logger.error(e.getMessage(), e);
        HashMap<String, Object> errorResp = getResponse(HttpStatus.INTERNAL_SERVER_ERROR, e);
        return errorResp;
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public @ResponseBody
    HashMap<String, Object> handleInternalServerException(UnauthorizedAccessException e) {
        logger.warn(e.getMessage(), e);
        HashMap<String, Object> errorResp = getResponse(HttpStatus.UNAUTHORIZED, e);
        return errorResp;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    HashMap<String, Object> handleResourceNotFoundException(ResourceNotFoundException e) {
        logger.error(e.getMessage(), e);
        HashMap<String, Object> errorResp = getResponse(HttpStatus.NOT_FOUND, e);
        return errorResp;
    }

    /**
     * spring boot Validated 的相关校验
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    HashMap<String, Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error(e.getMessage(), e);
        HashMap<String, Object> errorResp = new HashMap<>();
        BindingResult result = e.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder builder = new StringBuilder();
        for (FieldError error : fieldErrors) {
            builder.append(error.getDefaultMessage()).append("。");
        }
        errorResp.put(STATUS, HttpStatus.BAD_REQUEST);
        errorResp.put(FRONT_END_MESSAGE, builder);
        return errorResp;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    HashMap<String, Object> handleValidationException(ConstraintViolationException e) {

        logger.warn(e.getMessage(), e);
        HashMap<String, Object> errorResp = new HashMap<>();
        errorResp.put(TIMESTAMP, System.currentTimeMillis());
        errorResp.put(STATUS, HttpStatus.BAD_REQUEST.value());
        errorResp.put(ERROR, HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorResp.put(EXCEPTION, e.getClass().toString());

        StringBuilder message = new StringBuilder();
        for (ConstraintViolation<?> s : e.getConstraintViolations()) {
            message.append("[").append(s.getInvalidValue()).append(": ").append(s.getMessage()).append("]");
        }
        errorResp.put(MESSAGE, message.toString());
        if (e.getStackTrace().length >= 1) {
            StackTraceElement stackTraceElement = e.getStackTrace()[0];
            errorResp.put(TRACEINFO, stackTraceElement.getClassName() + ":"
                    + stackTraceElement.getMethodName() + "(..):"
                    + stackTraceElement.getLineNumber());
        }

        return errorResp;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    HashMap<String, Object> handleDefault(Exception e) {
        HashMap<String, Object> errorResp = new HashMap<>();
        errorResp.put(TIMESTAMP, System.currentTimeMillis());
        errorResp.put(STATUS, HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResp.put(ERROR, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        errorResp.put(EXCEPTION, e.getClass().toString());
        errorResp.put(MESSAGE, e.getMessage());

        String tmp;
        if (e.getStackTrace().length >= 1) {
            StackTraceElement stackTraceElement = e.getStackTrace()[0];
            tmp = stackTraceElement.getClassName() + ":"
                    + stackTraceElement.getMethodName() + "(..):"
                    + stackTraceElement.getLineNumber();
            errorResp.put(TRACEINFO, tmp);
        }
        logger.error(e.getMessage(), e);

        errorResp.put(FRONT_END_MESSAGE, "未知异常：" + e.getMessage());
        return errorResp;
    }

    private HashMap<String, Object> getResponse(HttpStatus httpStatus, BaseException e) {
        HashMap<String, Object> errorResp = new HashMap<>();
        errorResp.put(TIMESTAMP, System.currentTimeMillis());
        errorResp.put(STATUS, httpStatus.value());
        errorResp.put(ERROR, httpStatus.getReasonPhrase());
        errorResp.put(EXCEPTION, e.getClass().toString());
        errorResp.put(MESSAGE, e.getMessage());

        if (e.getStackTrace().length >= 1) {
            StackTraceElement stackTraceElement = e.getStackTrace()[0];
            errorResp.put(TRACEINFO, stackTraceElement.getClassName() + ":"
                    + stackTraceElement.getMethodName() + "(..):"
                    + stackTraceElement.getLineNumber());
        }
        if (e.getFrontEndMessage() != null && !"".equals(e.getFrontEndMessage().trim())) {
            errorResp.put(FRONT_END_MESSAGE, e.getFrontEndMessage());
        }
        if (e.getValidationMessage() != null && !"".equals(e.getValidationMessage().trim())) {
            errorResp.put(VALIDATION_MESSAGE, e.getValidationMessage());
        }
        if (e.getFrontEndMessage() == null && e.getValidationMessage() == null) {
            errorResp.put(FRONT_END_MESSAGE, e.getMessage());
        }
        return errorResp;
    }

    private HashMap<String, Object> getResponse(HttpStatus httpStatus, Exception e, String message) {
        HashMap<String, Object> errorResp = new HashMap<>();
        errorResp.put(TIMESTAMP, System.currentTimeMillis());
        errorResp.put(STATUS, httpStatus.value());
        errorResp.put(ERROR, httpStatus.getReasonPhrase());
        errorResp.put(EXCEPTION, e.getClass().toString());
        errorResp.put(MESSAGE, e.getMessage());

        if (e.getStackTrace().length >= 1) {
            StackTraceElement stackTraceElement = e.getStackTrace()[0];
            errorResp.put(TRACEINFO, stackTraceElement.getClassName() + ":"
                    + stackTraceElement.getMethodName() + "(..):"
                    + stackTraceElement.getLineNumber());
        }
        errorResp.put(FRONT_END_MESSAGE, message);
        return errorResp;
    }
}
