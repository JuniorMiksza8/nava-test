package br.com.nava.test.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@DynamoDBTable(tableName = "postcode_request_log")
public class PostcodeRequestLog {

    @DynamoDBHashKey
    private String id;

    @DynamoDBAttribute
    private Postcode postcode;

    @DynamoDBAttribute
    private String requestDate;

    @DynamoDBAttribute
    private String responseDate;

    @DynamoDBAttribute
    private String errorMessage;
}
