package com.xzx.crawler.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author xzx
 * @date 2021/01/04 02/36
 */
@Slf4j
@ControllerAdvice
public class ExceptionInterceptor {

    @ResponseBody
    @ExceptionHandler(value = IllegalArgumentException.class)
    public void illegalArgHandler(IllegalArgumentException ie) {
        log.warn("illegalArg {} ", ie);
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public void exceptionHandler(Exception e) {
        log.warn("exception {}", e);
    }


}
