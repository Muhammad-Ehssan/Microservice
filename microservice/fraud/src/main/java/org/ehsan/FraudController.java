package org.ehsan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud")
@RequiredArgsConstructor
@Slf4j
public class FraudController {
    private final FraudService service;

    @GetMapping("/validate-fraudster/{customerId}")
    public FraudResponseInfo validateFraudster(@PathVariable("customerId") Integer customerId){
        FraudResponseInfo responseInfo;
        log.info("Validating fraudster for customer id {}", customerId);
        responseInfo = service.validateFraudster(customerId);
        log.info("Response received {}",responseInfo.toString());
        return responseInfo;
    }
}
