package br.com.nava.test.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class PostcodeDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 255512987987L;

    private String postcode;
    private String district;
    private String location;
    private String complement;
    private String city;
    private String state;
    private String stateCode;
    private String region;

}
