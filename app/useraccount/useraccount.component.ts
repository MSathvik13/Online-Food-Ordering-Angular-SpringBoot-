import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-useraccount',
  templateUrl: './useraccount.component.html',
  styleUrls: ['./useraccount.component.css']
})
export class UseraccountComponent implements OnInit {

  name = '';

  constructor(private router: Router, private activeRoute: ActivatedRoute ) { }

  ngOnInit(): void {
    this.name = this.activeRoute.snapshot.params['name'];
  }

  handleLogout() {

    this.router.navigate(['home']);

    // let homeObj : HomeComponent;
    // homeObj.viewLogin = false;

  }

}
