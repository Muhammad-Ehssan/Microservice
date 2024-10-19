package org.ehsan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void registerService(CustomerRequestInfo reqInfo){
        Customer customer = new Customer.CustomerBuilder()
                .name(reqInfo.getName())
                .email(reqInfo.getEmail())
                .country(reqInfo.getCountry())
                .build();
        customerRepository.save(customer);
    }
}
