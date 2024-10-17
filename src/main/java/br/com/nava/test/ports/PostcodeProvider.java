package br.com.nava.test.ports;

import br.com.nava.test.dto.PostcodeDto;
import br.com.nava.test.exceptions.PostcodeNotFoundException;
import br.com.nava.test.exceptions.PostcodeProviderUnavailableException;

public interface PostcodeProvider {

    public PostcodeDto findByPostcode(String postcode) throws PostcodeNotFoundException, PostcodeProviderUnavailableException;

}
