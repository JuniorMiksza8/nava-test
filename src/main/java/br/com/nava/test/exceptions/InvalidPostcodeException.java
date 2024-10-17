package br.com.nava.test.exceptions;

public class InvalidPostcodeException extends BaseException{
    public InvalidPostcodeException(String message) {
        super("POSTCODE400", message);
    }
}
