package org.ehsan;

import lombok.Data;

@Data
public class FraudResponseInfo {
    private Integer customerId;
    private Boolean fraudster;
}
