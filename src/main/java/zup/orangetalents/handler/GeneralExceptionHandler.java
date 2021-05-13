package zup.orangetalents.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import zup.orangetalents.exception.AddressException;
import zup.orangetalents.exception.UserException;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class) 
    public ParameterErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException expection) {

        List<FieldError> fieldErrors = expection.getBindingResult().getFieldErrors(); 
        List<ParameterErrorResponse.ParameterError> errors = new ArrayList<>();
        
        for(FieldError fieldError : fieldErrors) {
            String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            errors.add(new ParameterErrorResponse.ParameterError(fieldError.getField(),  mensagem));
        }

        return new ParameterErrorResponse(errors);
    }
    
	@ExceptionHandler(UserException.class)
	public final ResponseEntity<ErrorResponse> handleUserRegisterException(UserException exception, WebRequest request) {
		return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), exception.getErrorCode());
    }
	
	@ExceptionHandler(AddressException.class)
	public final ResponseEntity<ErrorResponse> handleAddressRegisterException(AddressException exception, WebRequest request) {
		return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), exception.getErrorCode());
    }
}