import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {Products} from './products/products';
import {Customers} from './customers/customers';
import {Billing} from './billing/billing';
import {BillingDetails} from './billing-details/billing-details';

const routes: Routes = [
  {
    path : "products" , component : Products
  },
  {
    path : "customers" , component : Customers
  },
  {
    path : "billing/:customerId" , component : Billing
  },
  {
    path : "billing/:billingId" , component : BillingDetails
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
