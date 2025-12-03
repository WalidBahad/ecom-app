package com.bahad.billingservice.web;


import com.bahad.billingservice.entities.Bill;
import com.bahad.billingservice.feign.CustomerRestClient;
import com.bahad.billingservice.feign.ProductRestClient;
import com.bahad.billingservice.repository.BillRepository;
import com.bahad.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BillRestController {
    @Autowired
    private BillRepository  billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;


    @GetMapping(path = "/bills/{id}")
    private Bill getBill(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getId()));
        });
        return bill;
    }


}
