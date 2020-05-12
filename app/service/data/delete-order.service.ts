import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DeleteOrderService {

  constructor(private httpRef: HttpClient) { }

  removeOrders(orderId) {
    return this.httpRef.delete(`http://localhost:8080/remove/orders/${orderId}`);
  }
}
