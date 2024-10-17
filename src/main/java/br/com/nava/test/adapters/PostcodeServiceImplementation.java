package br.com.nava.test.adapters;

import br.com.nava.test.dto.PostcodeDto;
import br.com.nava.test.exceptions.BaseException;
import br.com.nava.test.exceptions.InvalidPostcodeException;
import br.com.nava.test.exceptions.PostcodeNotFoundException;
import br.com.nava.test.exceptions.PostcodeProviderUnavailableException;
import br.com.nava.test.mapper.PostcodeRequestLogMapper;
import br.com.nava.test.ports.PostcodeProvider;
import br.com.nava.test.ports.PostcodeRequestLogService;
import br.com.nava.test.ports.PostcodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostcodeServiceImplementation implements PostcodeService {

    private final PostcodeProvider postcodeProvider;
    private final PostcodeRequestLogService postcodeRequestLogService;

    public PostcodeDto findByPostcode(String postcode) throws PostcodeNotFoundException, PostcodeProviderUnavailableException, InvalidPostcodeException {
        validatePostcode(postcode);
        LocalDateTime requestDate = LocalDateTime.now();

       try{
           var data = postcodeProvider.findByPostcode(postcode);
           createLog(data, requestDate, null);
           return data;
       }catch (BaseException e){
           createLog(null, requestDate, e.getMessage());
           throw e;
       }

    }

    public void createLog(PostcodeDto data,LocalDateTime requestDate,String errorMessage) {
       try{
           postcodeRequestLogService.save(PostcodeRequestLogMapper.create(data, requestDate, LocalDateTime.now(), errorMessage));
       }catch (Exception e){
           log.error("Error saving postcode request log: {}", e.getMessage());
       }
    }

    public void validatePostcode(String postcode) throws InvalidPostcodeException {
        String sizeRegex = "^\\d{8}$";
        String alphanumericRegex = "^[0-9]+$";
        String spaceRegex = "^\\S+$";

        if (postcode == null) {
            throw new InvalidPostcodeException("blank or null postcode is not allowed");
        }

        if (!postcode.matches(sizeRegex)) {
            throw new InvalidPostcodeException("postcode must be 8 digits");
        }

        if (!postcode.matches(alphanumericRegex)) {
            throw new InvalidPostcodeException("postcode must be alphanumeric");
        }

        if (!postcode.matches(spaceRegex)) {
            throw new InvalidPostcodeException("postcode must not contain spaces");
        }
    }

}
