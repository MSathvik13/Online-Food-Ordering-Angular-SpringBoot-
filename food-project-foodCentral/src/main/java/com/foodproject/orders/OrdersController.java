package com.foodproject.orders;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.foodproject.menu.Menu;
import com.foodproject.users.Users;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "Orders Manager", description= "Handle orders here!!")
public class OrdersController {
	
	@ApiModelProperty(notes="Tweak orders here!!")
	@Autowired
	OrdersService service;

	@ApiOperation(value = "Get all user orders", notes = "Hit this URL for getting all the user orders", response = List.class)
	@GetMapping("/user/{userId}/orders")
	Iterable<Orders> getAllUsers(@PathVariable Integer userId) {
		return service.getAllUserOrders(userId);
	}

	@ApiOperation(value = "Get all orders", notes = "Hit this URL for getting all orders", response = List.class)
	@GetMapping("/orders")
	Iterable<Orders> getAllOrders() {
		return service.getAllOrders();
	}
	Double foodPrice  ;
	@ApiOperation(value = "Create new orders", notes = "Hit this URL for adding a new order", response = String.class)
	@PostMapping("/add/orderOf/user/{userId}/food/{foodId}/restaurant/{restaurantId}/menu/{menuId}/price/{orderAmount}")
	String addOrder(@RequestBody Orders order, 
				 @PathVariable Integer userId,
				 @PathVariable int foodId,
				 @PathVariable int restaurantId,
				 @PathVariable int menuId
				 ) {
		order.setUser(new Users(userId, "", "", "", "", "","",""));
		order.setMenu(new Menu(menuId, foodId, restaurantId));
		service.addOrder(order);
		return "Order ID "+order.getOrderId()+" was placed.";
	}
	
	

	@ApiOperation(value = "Get an order by ID", notes = "Hit this URL to get an order by ID", response = Orders.class)
	@GetMapping("/orders/{orderId}")
	Optional<Orders> getOrderrById(@PathVariable int orderId) {
		return service.getOrdersById(orderId);
	}


	@ApiOperation(value = "Update an order", notes = "Hit this URL for updating an orders", response = String.class)
	@PutMapping("/update/orderOf/user/{userId}/food/{foodId}/restaurant/{restaurantId}/menu/{menuId}")
	String updateOrder(@RequestBody Orders order, 
			 @PathVariable Integer userId,
			 @PathVariable int foodId,
			 @PathVariable int restaurantId,
			 @PathVariable int menuId
			) {

		order.setUser(new Users(userId, "", "", "", "", "","",""));
		order.setMenu(new Menu(menuId, foodId, restaurantId));
		service.updateOrder(order);
		return "Order ID "+order.getOrderId()+" was updated.";
	}


	@ApiOperation(value = "Delete an orders", notes = "Hit this URL for removing an orders", response = String.class)
	@DeleteMapping(value = "/remove/orders/{id}")
	void deleteOrder(@PathVariable int id) {
		service.removeOrder(id);
	}	
	

	@ApiOperation(value = "Get user bill amount", notes = "Hit this URL for displaying user bill amount", response = Double.class)
	@GetMapping(value = "/get/userTotalAmount/{userId}")
	Double getUserTotalAmount(@PathVariable int userId) {
		return service.getUserTotalAmount(userId);
	}
	

	@ApiOperation(value = "Get a food's price", notes = "Hit this URL for getting a food's price", response = Double.class)
	@GetMapping(value = "/getFoodPrice/{menuId}")
	Double getFoodPrice(@PathVariable int menuId) {
		return service.getFoodPrice(menuId);
	}

	@ApiOperation(value = "Get user's ID using email", notes = "Hit this URL for fetching a user's ID using email", response = Integer.class)
	@GetMapping(value = "/getUserId/{email}")
	Integer getUserId(@PathVariable String email) {
		return (service.getUserId(email));
	}
	
	@ApiOperation(value = "Get user's Name using email", notes = "Hit this URL for fetching a user's Name using email", response = String.class)
	@GetMapping(value = "/getUserName/{email}")
	String getUserName(@PathVariable String email) {
		return service.getUserName(email);
	}
}
