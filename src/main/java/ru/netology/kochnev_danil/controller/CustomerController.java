package ru.netology.kochnev_danil.controller;


import org.springframework.web.bind.annotation.*;
import ru.netology.kochnev_danil.controller.dto.CustomerDTO;
import ru.netology.kochnev_danil.controller.dto.CustomersGetResponse;
import ru.netology.kochnev_danil.domain.Customer;
import ru.netology.kochnev_danil.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/customers/")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public CustomersGetResponse getCustomers(){
        List<Customer> customers = customerService.getCustomers();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName());
            customerDTOS.add(customerDTO);
        }
        return new CustomersGetResponse(customerDTOS);
    }

    @GetMapping("{customersId}")
    public CustomerDTO getCustomer(@PathVariable("customersId") int customersId){
        Customer customer = customerService.getCustomer(customersId);
        return new CustomerDTO(customer.getId(), customer.getName());
    }
    @PostMapping
    public CustomerDTO addCustomer(int id, String name){
        customerService.addCustomer(id, name);
        Customer customer = customerService.getCustomer(id);
        return new CustomerDTO(customer.getId(),customer.getName());
    }
}
