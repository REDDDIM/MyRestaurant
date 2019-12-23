package config;

import dto.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import services.exceptions.OrderException;
import services.exceptions.PositionException;
import services.exceptions.UserException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleConflict(
            Exception ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorType(ex.getClass().toString());
        errorDto.setMessage("An error has occurred : "+ex.getMessage());
        return handleExceptionInternal(ex, errorDto,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = PositionException.class)
    protected ResponseEntity<Object> handlePositionConflict(
            Exception ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorType(ex.getClass().toString());
        errorDto.setMessage("An error has occurred : "+ex.getMessage());
        return handleExceptionInternal(ex, errorDto,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = OrderException.class)
    protected ResponseEntity<Object> handleOrderConflict(
            Exception ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorType(ex.getClass().toString());
        errorDto.setMessage("An error has occurred : "+ex.getMessage());
        return handleExceptionInternal(ex, errorDto,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = UserException.class)
    protected ResponseEntity<Object> handleUserConflict(
            Exception ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorType(ex.getClass().toString());
        errorDto.setMessage("An error has occurred : "+ex.getMessage());
        return handleExceptionInternal(ex, errorDto,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
