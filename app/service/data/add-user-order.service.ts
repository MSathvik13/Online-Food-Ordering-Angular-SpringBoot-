import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class AddUserOrderService {
  responseBack: any;
  amount: number;
  constructor(private httpRef: HttpClient
  ) { }
  addOrder(userId, foodId, restaurantId, menuId, orderId, order) {
    this.httpRef.get(`http://localhost:8080/getFoodPrice/${menuId}`).subscribe(
      (responseBack) => {
        this.responseBack = responseBack;
        this.amount = this.responseBack;
      }
    );
    order["orderAmount"] = this.amount;
    order["orderId"] = orderId;
    return this.httpRef.post(`http://localhost:8080/add/orderOf/user/${userId}/food/${foodId}/restaurant/${restaurantId}/menu/${menuId}`, order);

  }

  /*    console.log(this.httpRef.get(`http://localhost:8083/getFoodPrice/2`).subscribe(
      (responseBack) => {
        this.responseBack = responseBack;
        console.log(this.responseBack);
      }
    )
    );*/
}
