package org.ehsan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@Slf4j
public class FraudService {

    private final FraudRepository repo;

    public FraudResponseInfo validateFraudster(Integer customerId){
        log.info("validateFraudster called for customerId: {}", customerId);
        FraudResponseInfo responseInfo = new FraudResponseInfo();
        Fraud fraud = new Fraud.FraudBuilder()
                .customerId(customerId).createdOn(LocalDateTime.now())
                .fraudster(false).build();
        repo.save(fraud);
        log.info("customerId: {} info saved", customerId);

        responseInfo.setCustomerId(customerId);
        responseInfo.setFraudster(false);
        return responseInfo;
    }
}
