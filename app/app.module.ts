import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { OrdersComponent } from './orders/orders.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RestaurantloginComponent } from './restaurantlogin/restaurantlogin.component';
import { RestaurantregisterComponent } from './restaurantregister/restaurantregister.component';
import { UseraccountComponent } from './useraccount/useraccount.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { UsersignupComponent } from './usersignup/usersignup.component';
import { AdminuserComponent } from './adminuser/adminuser.component';
import { MenuComponent } from './menu/menu.component';
import { ChickenComponent } from './chicken/chicken.component';
import { DessertsComponent } from './desserts/desserts.component';
import { RiceComponent } from './rice/rice.component';
import { RotisComponent } from './rotis/rotis.component';
import { WebStorageModule } from "ngx-web-storage";
import { LoginregisterComponent } from './loginregister/loginregister.component';
import { SearchComponent } from './search/search.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    OrdersComponent,
    NotFoundComponent,
    RestaurantloginComponent,
    RestaurantregisterComponent,
    UseraccountComponent,
    UserloginComponent,
    UsersignupComponent,
    AdminuserComponent,
    MenuComponent,
    ChickenComponent,
    DessertsComponent,
    RiceComponent,
    RotisComponent,
    LoginregisterComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    WebStorageModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
