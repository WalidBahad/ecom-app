package com.bahad.billingservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;


@Projection(name = "FullBilling" , types = Bill.class)
public interface BillingProjection {
    Long getid();
    Date getbillingDate();
    Long getcustomerId();
}
