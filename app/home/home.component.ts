import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TestService } from '../test.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  email: string;
  isAdmin: boolean = false;

  displayHeader: string = '';
  displayContent: string = "Service IT";
  lenOfContent: number = this.displayContent.length;
  location: number = 0;
  
  search: string = '';

  constructor(private storeService: TestService,
              private router: Router
  ) {
    setInterval(() => {
      if (this.location == this.lenOfContent) {
        this.displayHeader = '#';
        this.location = 0;
      } else {
        this.displayHeader += this.displayContent.charAt(this.location);
        this.location += 1;
      }
    }, 200);

  }
  

  clearToken() {
    this.storeService.clearToken();
  }

  isLoggedIn() {
    if (this.storeService.checkIfLoggedIn() != null) {
      //console.log(this.storeService.getUserId())
      return true;

    } else {
      return false;
    }

  }

  ngOnInit(): void {
    this.email= this.storeService.getEmail();
    console.log(this.email);
  }

}
