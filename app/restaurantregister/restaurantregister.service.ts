import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IRestaurant } from '../restaurant';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestaurantregisterService {

  constructor(private http: HttpClient) { }

  private _url: string = 'http://localhost:8080/add/restaurant';

  postRestaurant(details: IRestaurant): Observable<IRestaurant> {

    return this.http.post<IRestaurant>(this._url, details);

  }

  getRestaurant(): Observable<IRestaurant[]> {

    return this.http.get<IRestaurant[]>(this._url);

  }

}
