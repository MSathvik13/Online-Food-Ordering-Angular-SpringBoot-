import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GetUseridService {
  responseType: any;
  constructor(private httpRef: HttpClient) { }
  getUserId(email) {
    const options = { responseType: 'text' as 'text' };
    return this.httpRef.get(`http://localhost:8080/getUserId/${email}`, options);
  }
}
