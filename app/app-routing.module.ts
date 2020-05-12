import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { OrdersComponent } from './orders/orders.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { RestaurantloginComponent } from './restaurantlogin/restaurantlogin.component';
import { RestaurantregisterComponent } from './restaurantregister/restaurantregister.component';
import { UseraccountComponent } from './useraccount/useraccount.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { UsersignupComponent } from './usersignup/usersignup.component';
import { AdminuserComponent } from './adminuser/adminuser.component';
import { MenuComponent } from './menu/menu.component';
import { ChickenComponent } from './chicken/chicken.component';
import { RotisComponent } from './rotis/rotis.component';
import { DessertsComponent } from './desserts/desserts.component';
import { RiceComponent } from './rice/rice.component';
import { AppComponent } from './app.component';
import { LoginregisterComponent } from './loginregister/loginregister.component';



const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginregisterComponent },
  { path: 'signup', component: UsersignupComponent },
  {
    path: 'home', component: HomeComponent,
      children: [
        {
          path: 'admin', component: AdminuserComponent,
            children: [
               { path: 'user', component: UseraccountComponent }
            ]
          },
          { path: 'signup', component: UsersignupComponent }
      ]

  },
  { path: 'register', component: UsersignupComponent },
  { path: 'user/:name', component: UseraccountComponent },
  { path: 'admin', component: AdminuserComponent },
  { path: 'register-restaurant', component: RestaurantregisterComponent },
  { path: 'restaurant-login', component: RestaurantloginComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'orders', component: OrdersComponent },

  {

    path: 'checkout',

    redirectTo: 'localhost:9090'//,

    //pathMatch: 'full'

  },
  { path: 'menu', component: MenuComponent },
  { path: 'Chicken', component: ChickenComponent },
  { path: 'Rotis', component: RotisComponent },
  { path: 'Desserts', component: DessertsComponent },
  { path: 'Rice', component: RiceComponent },
  { path: '**', component: NotFoundComponent }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
