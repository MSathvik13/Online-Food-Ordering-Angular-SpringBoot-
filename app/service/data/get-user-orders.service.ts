import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrdersComponent } from '../../orders/orders.component';

@Injectable({
  providedIn: 'root'
})
export class GetUserOrdersService {
  responseType: any;
  constructor(private httpRef: HttpClient) { }

  getAllUserOrders(userId) {
    //const options = {responseType: 'text' as 'text'};
    return this.httpRef.get(`http://localhost:8080/user/${userId}/orders`);
  }
}
