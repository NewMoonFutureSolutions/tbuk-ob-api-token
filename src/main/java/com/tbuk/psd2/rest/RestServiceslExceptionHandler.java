package com.tbuk.psd2.rest;

import com.tbuk.psd2.rest.error.LinkServiceException1;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class RestServiceslExceptionHandler extends ResponseEntityExceptionHandler {

    // Let Spring BasicErrorController handle the exception, we just override the status code
    @ExceptionHandler(LinkServiceException1.class)
    public void springHandleNotFound(HttpServletResponse response) throws Exception {
        response.sendError(HttpStatus.UNAUTHORIZED.value());
    }
}