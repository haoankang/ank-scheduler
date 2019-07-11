package ank.hao.core.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义log
 */
public class ExecutorLog {

    private static final Logger logger = LoggerFactory.getLogger(ExecutorLog.class);

    public static void infoLog(String msg, Object... objects){
        logger.info(msg, objects);
    }

    public static void errorLog(String msg, Object... objects){
        logger.error(msg, objects);
    }

    public static void traceLog(String msg, Object... objects){
        logger.trace(msg, objects);
    }

}