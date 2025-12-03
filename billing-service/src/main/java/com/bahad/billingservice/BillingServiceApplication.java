package com.bahad.billingservice;

import com.bahad.billingservice.entities.Bill;
import com.bahad.billingservice.entities.ProductItem;
import com.bahad.billingservice.feign.CustomerRestClient;
import com.bahad.billingservice.feign.ProductRestClient;
import com.bahad.billingservice.model.Customer;
import com.bahad.billingservice.model.Product;
import com.bahad.billingservice.repository.BillRepository;
import com.bahad.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            BillRepository billRepository,
            ProductItemRepository productItemRepository,
            ProductRestClient productRestClient,
            CustomerRestClient customerRestClient) {
        return args -> {
            try {
                Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();
                Collection<Product> products = productRestClient.getAllProducts().getContent();

                customers.forEach(customer -> {
                    Bill bill = Bill.builder()
                            .billingDate(new Date())
                            .customerId(customer.getId())
                            .build();
                    billRepository.save(bill);
                    products.forEach(product -> {
                        ProductItem productItem = ProductItem.builder()
                                .bill(bill)
                                .productId(product.getId())
                                .quantity(1 + new Random().nextInt(10))
                                .unitPrice(product.getPrice())
                                .build();
                        productItemRepository.save(productItem);
                    });
                });
            } catch (Exception e) {
                System.err
                        .println("Warning: Could not initialize billing data. Dependent services may not be available: "
                                + e.getMessage());
            }
        };

    }

}
