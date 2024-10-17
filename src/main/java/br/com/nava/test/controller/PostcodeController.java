package br.com.nava.test.controller;

import br.com.nava.test.dto.PostcodeDto;
import br.com.nava.test.exceptions.InvalidPostcodeException;
import br.com.nava.test.exceptions.PostcodeNotFoundException;
import br.com.nava.test.exceptions.PostcodeProviderUnavailableException;
import br.com.nava.test.ports.PostcodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postcode")
@RequiredArgsConstructor
public class PostcodeController {

    private final PostcodeService postcodeService;

    @GetMapping("/{postcode}")
    public PostcodeDto findByPostcode(@PathVariable("postcode") String postcode) throws PostcodeNotFoundException, PostcodeProviderUnavailableException, InvalidPostcodeException {
        return postcodeService.findByPostcode(postcode);
    }

}
