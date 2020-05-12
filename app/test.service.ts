import { Injectable } from '@angular/core';
import { WebStorageService } from 'ngx-web-storage';

@Injectable({
  providedIn: 'root'
})

export class TestService {

  userIdToken: string = "userId";

  emailToken: string = "emailToken";

  userNameToken: string = "userNameToken";

  userPasswordToken: string = "userPasswordToken";

  userHouseNumberToken: string = "userHouseNumberToken";

  userLocalityToken: string = "userLocalityToken";

  userCityToken: string = "userCityToken";

  userPhoneNumberToken: string = "userPhoneNumberToken";


  result: string;

  constructor(private storage: WebStorageService) { }

  save(email) {

    this.storage.local.set(this.emailToken, email);

  }


  saveUser(userId, userName, userPassword, email, houseNum, locality, city, phoneNumber) {

    this.storage.local.set(this.userIdToken, userId);
    this.storage.local.set(this.userNameToken, userName);

    this.storage.local.set(this.userPasswordToken, userPassword);
    this.storage.local.set(this.emailToken, email);

    this.storage.local.set(this.userHouseNumberToken, houseNum);
    this.storage.local.set(this.userLocalityToken, locality);

    this.storage.local.set(this.userCityToken, city);
    this.storage.local.set(this.userPhoneNumberToken, phoneNumber);

  }

  getEmail() {
    return this.storage.local.get(this.emailToken);
  }


  getUser(value: string) {
    const result = this.storage.local.get(value);
    return this.result = result;
  }

  checkIfLoggedIn() {
    return this.storage.local.get(this.emailToken);
  }

  clearToken() {
    this.storage.local.clear();
  }

}
