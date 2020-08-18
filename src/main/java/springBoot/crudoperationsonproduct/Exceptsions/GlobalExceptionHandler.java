package springBoot.crudoperationsonproduct.Exceptsions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * @author KChatzisotiriou
 * @since 9/7/2020
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ErrorBody> handleBadRequestException(BadRequestException ex, WebRequest request) {
        ErrorBody errorBody = new ErrorBody(new Date(), request.getDescription(false), ex.getMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ErrorBody> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorBody errorBody = new ErrorBody(new Date(), request.getDescription(false), ex.getMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }


}
