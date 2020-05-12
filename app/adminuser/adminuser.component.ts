import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TestService } from '../test.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminuser',
  templateUrl: './adminuser.component.html',
  styleUrls: ['./adminuser.component.css']
})

export class AdminuserComponent implements OnInit {

  getResponse: any;

  constructor(private httpRef: HttpClient, private storeService: TestService, private router: Router) { }

  ngOnInit(): void {

    if (this.storeService.getEmail() === 'admin@foodBasket.com') {
      this.router.navigate(['/admin']);
    }
    else {
      this.router.navigate(['/']);
    }

  }

  clearToken() {
    this.storeService.clearToken();
  }

  isLoggedIn() {
    if (this.storeService.checkIfLoggedIn() != null) {
      return true;
    } else {
      return false;
    }
  }

  checkLoggedIn() {

    if (this.storeService.checkIfLoggedIn() == null) {
      return true;
    } else {
      return false;
    }
  }

  findUser(userId){

    console.log("id: "+ userId);

    let obs = this.httpRef.get("http://localhost:8080/user/" + userId.viewModel);
    obs.subscribe((responseBack) => {

      this.getResponse = responseBack;

      if (this.getResponse != null) {

        console.log(this.getResponse);

      }
      else {
        console.log("Not Found!");
      }
    });

  }

  removeUser(userId){

    console.log("id: " + userId);

    const options = { responseType: 'text' as 'text' };

    let obs = this.httpRef.delete("http://localhost:8080/user/delete/" + userId.viewModel);
    obs.subscribe((responseBack) => {

      this.getResponse = responseBack;

      if (this.getResponse === "User Has been removed successfully!") {

        console.log(this.getResponse);

      }
      else {
        console.log("Not Found!");
      }
    });

  }

  findRestaurant(restaurantId){

    console.log("id: " + restaurantId);

    let obs = this.httpRef.get("http://localhost:8080//get/restaurantById/" + restaurantId.viewModel);
    obs.subscribe((responseBack) => {

      this.getResponse = responseBack;

      if (this.getResponse != null) {

        console.log(this.getResponse);

      }
      else {
        console.log("Not Found!");
      }
    });

  }

  removeRestaurant(restaurantId){

    console.log("id: " + restaurantId);

    const options = { responseType: 'text' as 'text' };

    let obs = this.httpRef.delete("http://localhost:8080/user/delete/" + restaurantId.viewModel);
    obs.subscribe((responseBack) => {

      this.getResponse = responseBack;

      if (this.getResponse === "Restaurant removed successfully!") {

        console.log(this.getResponse);

      }
      else {
        console.log("Not Found!");
      }
    });

  }

}
