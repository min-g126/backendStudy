package chap04exceptionhandlerpractice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentialsException.class)
    public String handleInvalidCredentialsException() {
        return "error/401";
    }
}
