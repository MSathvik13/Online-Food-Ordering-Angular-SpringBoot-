import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TestService } from './test.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = "Food Basket";
  constructor() {}


}
