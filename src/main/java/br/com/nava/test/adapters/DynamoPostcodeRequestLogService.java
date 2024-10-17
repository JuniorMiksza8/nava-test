package br.com.nava.test.adapters;

import br.com.nava.test.entity.PostcodeRequestLog;
import br.com.nava.test.ports.PostcodeRequestLogService;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DynamoPostcodeRequestLogService implements PostcodeRequestLogService {

    private final DynamoDBMapper dynamoDBMapper;

    public PostcodeRequestLog save(PostcodeRequestLog postcodeRequestLog) {
        postcodeRequestLog.setId(UUID.randomUUID().toString());
        dynamoDBMapper.save(postcodeRequestLog);
        return postcodeRequestLog;
    }

}
