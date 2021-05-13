package zup.orangetalents.exception;

import org.springframework.http.HttpStatus;

public class AddressException extends Exception {

	private HttpStatus errorCode;
    private String message;

    public AddressException(HttpStatus errorCode, String message) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}