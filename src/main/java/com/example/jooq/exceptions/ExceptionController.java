package com.example.jooq.exceptions;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {

    Log logger = LogFactory.getLog(ExceptionController.class);

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public void HttpRequestMethodNotSupportedExceptionMethod(HttpServletRequest req, Exception e){
        logger.info(e);
    }

}
