package config;

import dto.ErrorDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import services.exceptions.OrderException;
import services.exceptions.PositionException;
import services.exceptions.UserException;

import javax.persistence.NoResultException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler  {

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<ErrorDto> handleConflict(
            Exception ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorType(ex.getClass().toString());
        errorDto.setMessage("An error has occurred : "+ex.getMessage());
        return new ResponseEntity(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = PositionException.class)
    protected ResponseEntity<ErrorDto> handlePositionConflict(
            Exception ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorType(ex.getClass().toString());
        errorDto.setMessage("An error has occurred : "+ex.getMessage());
        return new ResponseEntity(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = OrderException.class)
    protected ResponseEntity<ErrorDto> handleOrderConflict(
            Exception ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorType(ex.getClass().toString());
        errorDto.setMessage("An error has occurred : "+ex.getMessage());
        return new ResponseEntity(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = UserException.class)
    protected ResponseEntity<ErrorDto> handleUserConflict(
            Exception ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorType(ex.getClass().toString());
        errorDto.setMessage("An error has occurred : "+ex.getMessage());
        return new ResponseEntity(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    protected ResponseEntity<ErrorDto> handle404Conflict(
            Exception ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorType(ex.getClass().toString());
        errorDto.setMessage("An error has occurred : "+ex.getMessage());
        return new ResponseEntity(errorDto, HttpStatus.NOT_FOUND);
    }
}
