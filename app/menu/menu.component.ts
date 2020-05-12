import { Component, OnInit } from '@angular/core';
import { TestService } from '../test.service';
import { GetUsernameService } from '../service/data/get-username.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  responseBack: any;
  userName: any;
  email: string = "";
  constructor(private storeService: TestService,
    private getUserName: GetUsernameService
  ) {
    this.email = this.storeService.getEmail();
    console.log(this.email);
    this.getUsername();

  }

  getUsername() {
    this.getUserName.getUserName(this.email).subscribe(
      (responseBack) => {
        this.responseBack = responseBack;
        this.userName = this.responseBack;
        console.log(this.userName);
      }
    );
  }

  ngOnInit(): void {
  }

}
