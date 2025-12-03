package com.bahad.billingservice.feign;

import com.bahad.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/api/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/api/customers")
    PagedModel<Customer> getAllCustomers();
//PagedModel<T> est une classe fournie par Spring HATEOAS
// pour représenter une collection paginée avec des métadonnées :
//
//_embedded → les objets réels (customers)
//
//_links → les liens de navigation (HATEOAS)
//
//page → les infos de pagination
}
