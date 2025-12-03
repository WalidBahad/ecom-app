import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { Products } from './products/products';
import { HttpClientModule } from '@angular/common/http';
import { Customers } from './customers/customers';
import { Billing } from './billing/billing';
import { BillingDetails } from './billing-details/billing-details';


@NgModule({
  declarations: [
    App,
    Products,
    Customers,
    Billing,
    BillingDetails
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners()
  ],
  bootstrap: [App]
})
export class AppModule { }
