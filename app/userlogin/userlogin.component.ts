import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { TestService } from '../test.service';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit {
  isSignIn: boolean = false;
  isSignUp: boolean = false;

  showAlertInLogin: boolean = false;
  messageLogin: string;

  showAlert: boolean = false;
  message: string;

  post: any;


  constructor(private httpRef: HttpClient, private storeService: TestService, private router: Router) { }

  ngOnInit(): void {
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

  // call getUserByEmail() on (change) to find if the user doesn't exist...

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
    // else if(password === 'adminlogin' && email === 'admin@admin.com'){
    //   // this.router.navigate(['/admin']);

    //   // Admin can delete a user, restaurant and view all orders...

    // }
    else {
      console.log("Validation successful");

      const options = { responseType: 'text' as 'text' };

      let obs = this.httpRef.get("http://localhost:8080/user/signin/" + email.viewModel + "/" + password.viewModel, options);
      obs.subscribe((responseBack) =>
        this.processResponse(responseBack, password, email)
      );
    }
    console.log(password.viewModel + "!!!" + email.viewModel);
  }


  processResponse(responseBack: string, password, email) {

    if (responseBack === "Login Successful!") {

      console.log("Password and email validated");
      this.storeService.save(email.value);
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


  // SignUp data validation and processing...
  signupValidate(email, name, password, doorNum, locality, city, phone) {

    this.showAlert = false;

    if (email == null || name == null || doorNum == null || locality == null || city == null || phone == null) {
      console.log("Resolve Empty Fields!");
    }
    else {
      console.log("got the response email: " + email + " name: " + name);
    }

    if (email.invalid || name.invalid || doorNum.invalid || locality.invalid || city.invalid || phone.invalid) {
      console.log("validation failed");
    }
    else {

      console.log("validation was successfull");

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


  processSignUpResponse(responseBack, email) {

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


}
