package br.com.nava.test.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class RequestErrorResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String code;
    private String message;
}
