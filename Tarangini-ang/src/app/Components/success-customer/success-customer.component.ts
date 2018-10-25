import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { CustomerService } from '../../Service/customer.service';
import { Customer } from '../../Model/customer';

@Component({
  selector: 'app-success-customer',
  templateUrl: './success-customer.component.html',
  styleUrls: ['./success-customer.component.css']
})
export class SuccessCustomerComponent implements OnInit {

  customer: Customer;
  constructor(
    private activatedRoute: ActivatedRoute,
    private customerService: CustomerService,
    private router: Router
  ) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(
      (params) => {
        let orderId = params['id'];
        if (orderId) {
          this.customerService.getCustomerByOrderNumber(orderId).subscribe(
            (data) => this.customer = data
          );
        }
      }
    );
  }

  goHome() {
    this.router.navigateByUrl("/");
  }


}
