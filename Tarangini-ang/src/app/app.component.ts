import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string;
  logoUrl: String;
  type: string = "maxSpeed";
  srchValue: string = "";

  constructor(
    private router: Router
  ) {
    this.title = "Tarangini Ltd.";
    this.logoUrl = "/assets/image/logo.png";
  }

  doSearch() {
    this.router.navigate(["/listPlans"], { queryParams: { type: this.type, srchValue: this.srchValue } });
  }

  doChangeType(type, ele) {
    this.type = type;
    this.srchValue = "";
    switch (type) {
      case 'maxSpeed': ele.placeholder = "Max Speed"; ele.type = "number"; break;
      case 'maxUsage': ele.placeholder = "Data Limit"; ele.type = "number"; break;
      case 'chargePerMonth': ele.placeholder = "Charges/month"; ele.type = "number"; break;

    }
  }
}
