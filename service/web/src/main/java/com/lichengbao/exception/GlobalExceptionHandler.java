/**
 * 
 */
package com.lichengbao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author jwang
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<ErrorResult> handleValidationException(MethodArgumentNotValidException e) {
		return new ResponseEntity<>(ErrorResult.handleValidateErrors(e.getBindingResult().getAllErrors()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ ObjectRetrievalFailureException.class })
	public ResponseEntity<ErrorResult> handleRetrievalException(ObjectRetrievalFailureException e) {
		return new ResponseEntity<>(ErrorResult.handleRetrievalErrors(e), HttpStatus.NOT_FOUND);
	}
	
}

