package br.com.nava.test.client;

import br.com.nava.test.dto.CorreiosPostcodeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        url = "${correios.url}",
        name = "CorreiosClient",
        configuration = CorreiosClientConfig.class
)
public interface CorreiosClient {


     @GetMapping("/ws/{postcode}/json")
     ResponseEntity<CorreiosPostcodeDto> getPostcode(@PathVariable("postcode") String postcode);

}
