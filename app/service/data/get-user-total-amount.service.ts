import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GetUserTotalAmountService {
  responseBack: any;
  amount: string;
  constructor(private httpRef: HttpClient) { }

  getUserTotalAmount(userId) {
    return this.httpRef.get(`http://localhost:8080/get/userTotalAmount/${userId}`);
  }
}

