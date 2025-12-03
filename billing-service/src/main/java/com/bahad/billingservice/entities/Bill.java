package com.bahad.billingservice.entities;




import com.bahad.billingservice.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Bill { //classe persistante il se trouve dans la bd
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems = new ArrayList<>();
    private Long customerId;
    @Transient  //cette attribut est dans la calsse mais auccun e relation avec la base de donnée
    private Customer customer;


    public double getTotal() {
        double somme = 0;
        for (ProductItem pi : productItems) {
            somme += pi.getAmount();
        }
        return somme;
    }
}
