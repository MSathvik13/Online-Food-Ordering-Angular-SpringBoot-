import { Component, OnInit } from '@angular/core';
import { AddUserOrderService } from '../service/data/add-user-order.service';
import { GetUserOrdersService } from '../service/data/get-user-orders.service';
import { GetUserTotalAmountService } from '../service/data/get-user-total-amount.service';
import { HttpClient } from '@angular/common/http';
import { GetOrderByIdService } from '../service/data/get-order-by-id.service';
import { DeleteOrderService } from '../service/data/delete-order.service';
import { GetUseridService } from '../service/data/get-userid.service';
import { TestService } from '../test.service';
import { GetUsernameService } from '../service/data/get-username.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  userId: any;
  userName: any;
  orderId: string = "";
  email: string = "";
  foodId: string = "";
  restaurantId: string = "";
  menuId: string = "";
  responseBack: any;
  amount: string = "";
  userOrders:any = [];
  //order: string = "";
  orders: string = "";
  new: any;
  // Some hard coded objects.
  user: Object = {
    "userId": 3,
    "userName": "Neo Fenimino",
    "userPassword": "1001",
    "door_no": "12",
    "locality": "Sandra street",
    "city": "Hollandpuram",
    "userPhone": "8010100101",
    "email": "Neo@live.com"
  };
  
  restaurant: Object = {
    "restaurantId": 5,
    "restaurantName": "Sanba's Attique",
    "ownerUserName": "Sanba",
    "ownerPassword": "Sanba",
    "restaurantPhone": "182012111",
    "locality": "Moscow"
  };

  order: Object = {
    "menu": {
      "food": {
        "foodId": 0,
        "foodName": "string",
        "foodOrigin": "string",
        "foodPrice": 0,
        "vegNonveg": "string"
      },
      "menuId": 0,
      "restaurant": {
        "locality": "string",
        "ownerPassword": "string",
        "ownerUserName": "string",
        "restaurantId": 0,
        "restaurantName": "string",
        "restaurantPhone": "string"
      }
    },
    "orderAmount": 150,
    "orderId": 6,
    "user": {
      "city": "string",
      "door_no": "string",
      "email": "string",
      "locality": "string",
      "userId": 0,
      "userName": "string",
      "userPassword": "string",
      "userPhone": "string"
    }
  };

  constructor(private addService: AddUserOrderService,
    private getAmount: GetUserTotalAmountService,
    private getOrderByOrderId: GetOrderByIdService,
    private httpRef: HttpClient,
    private getUserOrder: GetUserOrdersService,
    private removeAnOrder: DeleteOrderService,
    private getUserId: GetUseridService,
    private storeService: TestService,
    private getUserName: GetUsernameService
  ) {
    // Fetch user email ID from WebServiceStorage
    this.email = this.storeService.getEmail();
    this.getUserid();
    this.getUsername();
    //this.userId = this.user["userId"];
    
  }

  ngOnInit(): void {


  }
  // Fetch user ID from localhost:8080
  getUserid() {
    this.getUserId.getUserId(this.email).subscribe(
      (responseBack) => {
        this.responseBack = responseBack;
        this.userId = this.responseBack;
      }
    );
  }

  getUsername() {
    this.getUserName.getUserName(this.email).subscribe(
      (responseBack) => {
        this.responseBack = responseBack;
        this.userName = this.responseBack;
      }
    );
  }



  // Gets all orders. OK
  getAllUserOrders(uId) {
    this.getUserOrder.getAllUserOrders(uId).subscribe(
      (responseBack) => {
        this.responseBack = responseBack;
        this.userOrders = this.responseBack;
      }
    );
  }

  // Fetch all orders.
  /*
  getAllOrders() {
    let obs = this.httpRef.get("http://localhost:8080/orders"
    );

    obs.subscribe(
      (responseBack) => {
        this.responseBack = responseBack;
        console.log(this.responseBack);
      }
    );
  }*/

  // Fetch an order by id OK
  getByOrderId() {

    this.getOrderByOrderId.getByOrderId(this.orderId).subscribe(
      (responseBack) => {
        this.responseBack = responseBack;
        this.order = JSON.stringify(this.responseBack.menu.food["foodName"]);
        console.log("Orders fetched by order ID" + this.order);
      }
    );
  }

  // Add an order ** POST
  addOrder() {
    this.addService.addOrder(this.userId, this.foodId, this.restaurantId, this.menuId, this.orderId, this.order).subscribe(
      (responseBack) => {
        this.responseBack = responseBack;
        console.log(this.responseBack);
      }
    );
  }

  // Retrieves a user's final bill amount. OK
  userBillAmount(uId) {

    this.getAmount.getUserTotalAmount(uId).subscribe(
      (responseBack) => {

        this.responseBack = responseBack;
        this.amount = this.responseBack
        console.log(this.amount);
      }
    );
  }

  // Remove of an order using orderId
  removeOrder(oId) {
    this.removeAnOrder.removeOrders(oId).subscribe();
  }

  CreateTableFromJSON() {

    var myArray = [];
    myArray = this.userOrders;
    console.log(this.userOrders);

    // CREATE DYNAMIC TABLE. document.getElementById("myTable");
    var table = document.createElement("table");

    // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

    var row = `<tr class="thead-primary font-weight-bold" style="background-color: #5DADE2;">
                   <td>Food Name</td>
                   <td>Restaurant Name</td>
                   <td>Origin</td>
                   <td>Order Price</td>
               </tr>`
    table.innerHTML += row;

    // ADD JSON DATA TO THE TABLE AS ROWS.
    for (var i = 0; i < myArray.length; i++) {
      row = `<tr>
            <td>${myArray[i].menu.food["foodName"]}</td>
            <td>${myArray[i].menu.restaurant["restaurantName"]}</td>
            <td>${myArray[i].menu.food["foodOrigin"]}</td>
            <td>Rs. ${myArray[i].orderAmount} </td>
            </tr>`
      table.innerHTML += row;
    }

    // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER. <button class="btn btn-danger" (click)="removeOrder(${myArray[i].orderId})">Remove</button>
    var divContainer = document.getElementById("showData");
    divContainer.innerHTML = "";
    divContainer.appendChild(table);
  }

}

