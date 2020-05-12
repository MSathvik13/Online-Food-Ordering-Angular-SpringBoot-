import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GetOrderByIdService {

  constructor(private httpRef: HttpClient) { }

  getByOrderId(orderId) {
    return  this.httpRef.get(`http://localhost:8080/orders/${orderId}`);
  }
}
