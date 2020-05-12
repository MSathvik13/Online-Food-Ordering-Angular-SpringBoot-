import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GetUsernameService {
  responseType: any;
  constructor(private httpRef: HttpClient) { }
  getUserName(email) {
    const options = { responseType: 'text' as 'text' };
    return this.httpRef.get(`http://localhost:8080/getUserName/${email}`, options);
  }
}
