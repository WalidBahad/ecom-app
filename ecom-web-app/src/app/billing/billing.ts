import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-billing',
  standalone: false,
  templateUrl: './billing.html',
  styleUrl: './billing.css',
})
export class Billing implements OnInit{
  billing:any;
  customerId!:number;

  constructor(private http:HttpClient , private router: Router, private route:ActivatedRoute) {
    this.customerId = route.snapshot.params['customerId'];
  }
  ngOnInit(): void {
    this.http.get("http://localhost:9999/billing-service/bills/searsh/byCustomerId?projection=FullBilling&customerId="+this.customerId).subscribe({
      next : (data) => {
        this.billing = data;
      } ,
      error : (err) => {}

    });

  }
  getBillingDetail(b : any) {
      this.router.navigateByUrl("/billing-details/" + b.id);
  }

}
