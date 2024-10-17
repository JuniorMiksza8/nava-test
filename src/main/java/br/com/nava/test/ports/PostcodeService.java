package br.com.nava.test.ports;

import br.com.nava.test.dto.PostcodeDto;
import br.com.nava.test.exceptions.InvalidPostcodeException;
import br.com.nava.test.exceptions.PostcodeNotFoundException;
import br.com.nava.test.exceptions.PostcodeProviderUnavailableException;

public interface PostcodeService {

    public PostcodeDto findByPostcode(String postcode) throws PostcodeNotFoundException, PostcodeProviderUnavailableException, InvalidPostcodeException;

}
