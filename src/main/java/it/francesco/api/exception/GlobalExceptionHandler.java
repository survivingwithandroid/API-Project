package it.francesco.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// Handle resource not found
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        CustomErrorDetails errorDetails = new CustomErrorDetails("Runtime error",
        					HttpStatus.NOT_FOUND.value(), 
        					ex.getMessage(),
        					"http://absolute_uri");
        
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(ResourceNotFoundException ex, WebRequest request) {
        CustomErrorDetails errorDetails = new CustomErrorDetails("Runtime error",
        					HttpStatus.INTERNAL_SERVER_ERROR.value(), 
        					ex.getMessage(),
        					"http://absolute_uri");
        
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
   }
	
   // Implement other Exception Handler according to the Interoperability spec
}
