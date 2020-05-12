import { Component, OnInit } from '@angular/core';
import { FormGroup ,Validators, FormBuilder } from '@angular/forms';
import { RestaurantregisterService } from './restaurantregister.service';

@Component({
  selector: 'app-restaurantregister',
  templateUrl: './restaurantregister.component.html',
  styleUrls: ['./restaurantregister.component.css']
})
export class RestaurantregisterComponent implements OnInit {

  constructor(private fb: FormBuilder, private restaurantDetails: RestaurantregisterService) { }

    restaurantForm = this.fb.group({
      RestaurantName: ['', [Validators.required], [Validators.minLength(4)]],
      email: [''],
      contactNumber: [''],
      locality: [''],
      password: ['']

    });

//
  ngOnInit(): void {
  }

  get name() {
    return this.restaurantForm.get('name');
  }

  //
  onSubmit() {
    this.restaurantDetails.postRestaurant(this.restaurantForm.value).subscribe(
      () => console.log("Submitted!")
      );
  }

}
