import { Component, OnInit } from '@angular/core';
import { TestService } from '../test.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { WebStorageService } from 'ngx-web-storage';

@Component({
  selector: 'app-loginregister',
  templateUrl: './loginregister.component.html',
  styleUrls: ['./loginregister.component.css']
})
export class LoginregisterComponent implements OnInit {

  isSignIn: boolean = false;
  isSignUp: boolean = false;

  showAlertInLogin: boolean = false;
  messageLogin: string;

  showAlert: boolean = false;
  message: string;

  getResponse: any;

  post: any;

  name: string;
  password: string;
  email: string;
  house: string;
  locality: string;
  city: string;
  phoneNumber: string;

  profileView : boolean = false;

  constructor( private httpRef: HttpClient, private storeService: TestService, private router : Router) {

  }

  ngOnInit(): void {
    this.name = this.storeService.getUser("userNameToken");
    this.password = this.storeService.getUser("userPasswordToken");
    this.email = this.storeService.getUser("emailToken");
    this.house = this.storeService.getUser("userHouseNumberToken");
    this.locality = this.storeService.getUser("userLocalityToken");
    this.city = this.storeService.getUser("userCityToken");
    this.phoneNumber = this.storeService.getUser("userPhoneNumberToken");


    // alternate for authGuard and CanActivate...
    if(this.email === 'admin@foodbasket.com'){
      this.router.navigate(['/admin']);
    }
    else{
      this.router.navigate(['/']);
    }

    console.log(this.name + " " + this.password + " "+this.email+" "+this.house+" "+this.locality+" "+this.city+" "+this.phoneNumber);
  }

  signInButton() {
    this.isSignIn = true;
    this.isSignUp = false;
  }

  signUpButton() {
    this.isSignUp = true;
    this.isSignIn = false;
  }

  hide() {
    this.isSignIn = false;
    this.isSignUp = false;
  }

// User SignIn...
  loginValidate(password, email) {

    this.showAlertInLogin = false;

    if (password == null || email == null) {
      console.log("Some Fields are Empty!");
    }
    else {
      console.log("Got the password and email!");
    }

    if (password.invalid || email.invalid) {
      console.log("Validation failed");
    }
    else {

      if (password.viewModel === 'adminlogin' && email.viewModel === 'admin@foodBasket.com') {

        console.log("Admin access rights Granted!");

        const options = { responseType: 'text' as 'text' };

        let obs = this.httpRef.get("http://localhost:8080/user/signin/" + email.viewModel + "/" + password.viewModel, options);
        obs.subscribe((responseBack) => {

          if (responseBack === "Login Successful!") {

            console.log("Password and email validated");

            let obs = this.httpRef.get("http://localhost:8080/user/getByEmail/" + email.viewModel);
            obs.subscribe((userResponseBack) => {

              this.getResponse = userResponseBack;

              console.log("User returned: " + this.getResponse.userName)

              this.storeService.save(email.value);
              this.storeService.saveUser(this.getResponse.userId, this.getResponse.userName, this.getResponse.userPassword, this.getResponse.email,
                this.getResponse.door_no, this.getResponse.locality, this.getResponse.city, this.getResponse.userPhone);

              this.name = this.storeService.getUser("userNameToken");
              this.password = this.storeService.getUser("userPasswordToken");
              this.email = this.storeService.getUser("emailToken");
              this.house = this.storeService.getUser("userHouseNumberToken");
              this.locality = this.storeService.getUser("userLocalityToken");
              this.city = this.storeService.getUser("userCityToken");
              this.phoneNumber = this.storeService.getUser("userPhoneNumberToken");

              console.log(this.storeService.getUser("userNameToken"));

              this.router.navigate(['/admin']);

            });

          }
          else {
            console.log("Invalid Credentials!");
            this.showAlertInLogin = true;
            this.messageLogin = "Wrong Credentials!";
          }
        });

      }
      else{

        console.log("User access right granted!");

        const options = { responseType: 'text' as 'text' };

        let obs = this.httpRef.get("http://localhost:8080/user/signin/" + email.viewModel + "/" + password.viewModel, options);
        obs.subscribe((responseBack) =>{

          this.processResponse(responseBack, password, email);

        });
      }
    }
    console.log(password.viewModel + "!!!" + email.viewModel);

  }

// store user session decision...
  processResponse(responseBack: string, password, email) {

    if (responseBack === "Login Successful!") {

      this.router.navigate(['/']);

      console.log("Password and email validated");

      let obs = this.httpRef.get("http://localhost:8080/user/getByEmail/" + email.viewModel);
      obs.subscribe((userResponseBack) => {

        this.getResponse = userResponseBack;

        console.log("User returned: " + this.getResponse.userName)

        this.storeService.save(email.value);
        this.storeService.saveUser(this.getResponse.userId, this.getResponse.userName, this.getResponse.userPassword, this.getResponse.email,
          this.getResponse.door_no, this.getResponse.locality, this.getResponse.city, this.getResponse.userPhone);

        this.name = this.storeService.getUser("userNameToken");
        this.password = this.storeService.getUser("userPasswordToken");
        this.email = this.storeService.getUser("emailToken");
        this.house = this.storeService.getUser("userHouseNumberToken");
        this.locality = this.storeService.getUser("userLocalityToken");
        this.city = this.storeService.getUser("userCityToken");
        this.phoneNumber = this.storeService.getUser("userPhoneNumberToken");


        console.log(this.storeService.getUser("userNameToken"));

      });

    }
    else {
      console.log("Invalid Credentials!");
      this.showAlertInLogin = true;
      this.messageLogin = "looks like you have entered wrong credentials";
    }
  }


  checkLoggedIn() {

    if (this.storeService.checkIfLoggedIn() == null) {
      return true;
    } else {
      return false;
    }
  }


// User SignUp...
  signupValidate(email, name, password, doorNum, locality, city, phone) {

    this.showAlert = false;

    if (email == null || name == null || doorNum == null || locality == null || city == null || phone == null ) {
      console.log("Resolve Empty Fields!");
    }
    else {
      console.log("got the response email: " + email + " name: " + name);
    }

    if (email.invalid || name.invalid || doorNum.invalid || locality.invalid || city.invalid || phone.invalid) {
      console.log("Validation failed!");
    }
    else {

      console.log("Validation was successful!");

      this.post = {

        email: email.viewModel,
        userName: name.viewModel,
        userPassword: password.viewModel,
        door_no: doorNum.viewModel,
        locality: locality.viewModel,
        city: city.viewModel,
        userPhone: phone.viewModel

      }

      const options = { responseType: 'text' as 'text' };

      let obs = this.httpRef.post("http://localhost:8080/user/signup", this.post, options)

      obs.subscribe(
        (responseBack) =>
          this.processSignUpResponse(responseBack, email)
        );

      }

    console.log(email.viewModel + "{{{{}}}}" + name.viewModel + "{{{{{{{{}}}}}}}}" + password.viewModel);
  }


  processSignUpResponse(responseBack, email){

    if (responseBack.indexOf("We have sent a OTP code or link to your E-mail:") != -1) {
      console.log(responseBack);
      this.isSignUp = false;
      alert(responseBack);
    }
    else {
      console.log("something terrible happened");
      this.showAlert = true;
      this.message = "could not Register ! " + responseBack;
    }

  }

// View Profile
  viewProfile(){

    this.profileView = !this.profileView;

  }


}
