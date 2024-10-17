package br.com.nava.test.exceptions;

public class PostcodeProviderUnavailableException extends BaseException{
    public PostcodeProviderUnavailableException() {
        super("POSTCODEPROVIDER500", "postcode provider unavailable");
    }
}
