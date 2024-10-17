package br.com.nava.test.exceptions;

import lombok.Data;

@Data
public class BaseException extends Exception{
    private String code;
    private String message;

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
