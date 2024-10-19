package org.ehsan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CustomerService {
    final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void registerService(CustomerRequestInfo reqInfo) throws IllegalAccessException {
        log.info("Registering Customer");
        Customer customer = new Customer.CustomerBuilder()
                .name(reqInfo.getName())
                .email(reqInfo.getEmail())
                .country(reqInfo.getCountry())
                .build();
        customerRepository.saveAndFlush(customer);
        log.info("Customer registered successfully with id {}", customer.getId());
        RestTemplate restTemplate = new RestTemplate();
       FraudResponseInfo responseInfo = restTemplate.getForObject("http://localhost:8081/api/v1/fraud/validate-fraudster/{customer}",
                FraudResponseInfo.class,
                customer.getId());
       if(responseInfo != null){
           log.info("Response received from microservice Fraud {}",responseInfo.toString());
           if(responseInfo.getFraudster()){
               throw new IllegalAccessException("Customer is fraudster, so declining");
           }

       }else{
           throw  new RuntimeException("No response received from microservice");
       }
    }
}
