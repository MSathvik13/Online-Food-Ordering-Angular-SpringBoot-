import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  auto: boolean = true;
  press: boolean = true;

  getResponse : any;

  constructor(private httpRef: HttpClient) {

    this.autoSearch();

   }

  ngOnInit(): void {
  }

  autoSearch(){

    this.auto = !this.auto;

    let obs = this.httpRef.get("http://localhost:8080/restaurants");
    obs.subscribe((responseBack) => {
      this.getResponse = responseBack;

    });

  }


  handleSearchRestaurant(name){

    this.press = !this.press;
    console.log("Restaurants Name: " + name.viewModel)

    let obs = this.httpRef.get("http://localhost:8080/get/restaurantByName/" + name.viewModel);
    obs.subscribe((responseBack) => {
      this.getResponse = responseBack;

    });

  }


  handleSearchFood(name) {

    this.press = !this.press;
    console.log("Restaurants Name: " + name.viewModel)

    let obs = this.httpRef.get("http://localhost:8080/get/restaurantByName/" + name.viewModel);
    obs.subscribe((responseBack) => {
      this.getResponse = responseBack;

    });

  }


}
