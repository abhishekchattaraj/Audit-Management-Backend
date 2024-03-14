package com.mfpe.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mfpe.model.AuditResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	/**
	 * 
	 * @param ex
	 * @return ResponseEntity
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> validationExceptions(MethodArgumentNotValidException ex) {
		Map<String,String> resp=new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName =((FieldError)error).getField();
			String message=error.getDefaultMessage();
			log.error(message);
			resp.put(fieldName, message);
			
		});
		return new ResponseEntity<Map<String,String>>(resp, HttpStatus.FORBIDDEN);
	}

	/**
	 * 
	 * @param e
	 * @return ResponseEntity
	 */
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		log.error(e.getMessage());
		AuditResponse auditResponse = new AuditResponse();
		return new ResponseEntity<>(auditResponse, HttpStatus.OK);
	}

	@ExceptionHandler(value = ValidationException.class)
	@ResponseBody
	public ResponseEntity<?> ValidationException(ValidationException validataionException) {
		log.error(validataionException.getMessage());
		return new ResponseEntity<>(validataionException.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
