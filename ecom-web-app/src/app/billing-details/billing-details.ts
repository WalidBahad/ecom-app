import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-billing-details',
  standalone: false,
  templateUrl: './billing-details.html',
  styleUrl: './billing-details.css',
})
export class BillingDetails implements OnInit{
  billingDetail:any;
  billingId!:number;

  constructor(private http:HttpClient , private router: Router, private route:ActivatedRoute) {
    this.billingId = route.snapshot.params['billingId'];
  }
  ngOnInit(): void {
    this.http.get("http://localhost:9999/billing-service/FullBilling/"+this.billingId)
      .subscribe({
      next : (data) => {
        this.billingDetail = data;
      } ,
      error : (err) => {}

    });

  }


}
