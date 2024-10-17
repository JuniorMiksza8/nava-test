package br.com.nava.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CorreiosPostcodeDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("cep")
    private String postcode;

    @JsonProperty("logradouro")
    private String address;

    @JsonProperty("complemento")
    private String complement;

    // unknown field
    @JsonProperty("unidade")
    private String unity;

    @JsonProperty("bairro")
    private String district;

    @JsonProperty("localidade")
    private String city;

    @JsonProperty("uf")
    private String stateCode;

    @JsonProperty("estado")
    private String state;

    @JsonProperty("region")
    private String region;

    @JsonProperty("ibge")
    private String ibge;

    @JsonProperty("gia")
    private String gia;

    @JsonProperty("ddd")
    private String ddd;

    @JsonProperty("siafi")
    private String siafi;

}
