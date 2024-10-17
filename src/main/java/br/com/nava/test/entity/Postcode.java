package br.com.nava.test.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@DynamoDBDocument
public class Postcode {

    private String id;
    private String district;
    private String location;
    private String complement;
    private String city;
    private String state;
    private String stateCode;
    private String region;

}
