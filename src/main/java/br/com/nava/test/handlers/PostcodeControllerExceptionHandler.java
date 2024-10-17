package br.com.nava.test.handlers;


import br.com.nava.test.dto.RequestErrorResponse;
import br.com.nava.test.exceptions.InvalidPostcodeException;
import br.com.nava.test.exceptions.PostcodeNotFoundException;
import br.com.nava.test.exceptions.PostcodeProviderUnavailableException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice()
public class PostcodeControllerExceptionHandler {

    @ExceptionHandler(PostcodeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody RequestErrorResponse handlePostcodeNotFound(PostcodeNotFoundException postcodeNotFoundException) {
        return RequestErrorResponse.builder()
                .code(postcodeNotFoundException.getCode())
                .message(postcodeNotFoundException.getMessage())
                .build();
    }

    @ExceptionHandler(PostcodeProviderUnavailableException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody RequestErrorResponse handlePostcodeProviderUnavailable(PostcodeProviderUnavailableException exception) {
        return RequestErrorResponse.builder()
                .code(exception.getCode())
                .message("try again later")
                .build();
    }

    @ExceptionHandler(InvalidPostcodeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody RequestErrorResponse handleInvalidPostcode(InvalidPostcodeException exception) {
        return RequestErrorResponse.builder()
                .code(exception.getCode())
                .message(exception.getMessage())
                .build();
    }

}
