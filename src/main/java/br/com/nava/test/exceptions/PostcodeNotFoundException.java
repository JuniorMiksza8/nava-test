package br.com.nava.test.exceptions;


public class PostcodeNotFoundException extends BaseException {

    public PostcodeNotFoundException() {
        super("POSTCODE404", "postcode not found");
    }

}
