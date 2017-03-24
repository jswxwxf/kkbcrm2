/**
 * 
 */
package com.lichengbao.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author jwang
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResult {
	
	private String result = "错误";
	
	private String message;
	
	private Object errors;
	
	/**
	 * 
	 */
	public ErrorResult(Object errors) {
		this("错误", errors);
	}
	
	
	/**
	 * @param message
	 */
	public ErrorResult(String message) {
		this.message = message;
	}

	/**
	 * @param result
	 * @param errors
	 */
	public ErrorResult(String result, Object errors) {
		this.result = result;
		this.errors = errors;
	}

	public static ErrorResult handleValidateErrors(List<ObjectError> errors) {
		List<ValidateError> validateErrors = new ArrayList<>();
		// TODO: 用 java 1.8 的 stream 重新实现
		for (ObjectError objectError : errors) {
			validateErrors.add(ValidateError.from(objectError));
		}
		
		return new ErrorResult("校验错误", validateErrors);
	}

	/**
	 * @param e
	 * @return
	 */
	public static ErrorResult handleRetrievalErrors(ObjectRetrievalFailureException e) {
		return new ErrorResult(e.getMessage());
	}
	
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return the errors
	 */
	public Object getErrors() {
		return errors;
	}

	
}

@JsonInclude(JsonInclude.Include.NON_NULL)
class ValidateError {
	
	private String code;
	
	private String objectName;
	
	private String field;
	
	private String message;
	
	
	/**
	 * @param objectName
	 * @param field
	 * @param message
	 */
	public ValidateError(String code, String objectName, String field, String message) {
		this.code = code;
		this.objectName = objectName;
		this.field = field;
		this.message = message;
	}
	
	public static ValidateError from(ObjectError err) {
		if (err instanceof FieldError) {
			FieldError fieldError = (FieldError) err;
			return new ValidateError(fieldError.getCode(), fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
		}
		return new ValidateError(err.getCode(), err.getObjectName(), null, err.getDefaultMessage());
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @return the objectName
	 */
	public String getObjectName() {
		return objectName;
	}
	
	/**
	 * @param objectName the objectName to set
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	
	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}
	
	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
