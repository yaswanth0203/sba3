import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { ViewPlansComponent } from './Components/view-plans/view-plans.component';
import { CustformComponent } from './Components/custform/custform.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { SuccessCustomerComponent } from './Components/success-customer/success-customer.component';

const paths: Routes = [
  { path: '', component: ViewPlansComponent },
  { path: 'listPlans', component: ViewPlansComponent },
  { path: 'addCustomer/:title', component: CustformComponent },
  { path: 'successReport/:id', component: SuccessCustomerComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    ViewPlansComponent,
    CustformComponent,
    SuccessCustomerComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    AngularFontAwesomeModule,
    FormsModule,
    RouterModule.forRoot(paths)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
