package br.com.nava.test.adapters;

import br.com.nava.test.client.CorreiosClient;
import br.com.nava.test.dto.CorreiosPostcodeDto;
import br.com.nava.test.dto.PostcodeDto;
import br.com.nava.test.exceptions.PostcodeNotFoundException;
import br.com.nava.test.exceptions.PostcodeProviderUnavailableException;
import br.com.nava.test.mapper.PostcodeMapper;
import br.com.nava.test.ports.PostcodeProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CorreiosPostcodeProvider implements PostcodeProvider {

    private final CorreiosClient correiosClient;

    public PostcodeDto findByPostcode(String postcode) throws PostcodeNotFoundException, PostcodeProviderUnavailableException {

        ResponseEntity<CorreiosPostcodeDto> response = correiosClient.getPostcode(postcode);

        if ((response.getStatusCode().is2xxSuccessful() && response.getBody() == null) || response.getBody().getPostcode() == null) {
            throw new PostcodeNotFoundException();
        }

        return switch (response.getStatusCode().value()) {
            case 200 -> PostcodeMapper.fromCorreios(response.getBody());
            case 404 -> throw new PostcodeNotFoundException();
            default -> throw new PostcodeProviderUnavailableException();
        };
    }
}
