package com.foodproject.users;

import java.util.Optional;

public interface UsersInterface {
	
	// This interface will have all the important methods for all the operation
	// implement this method as a service and add a controller to show all the required request mappings
	// while implementing use a temporary database
	
	public String signUp(Users user);

	// this is during
	public boolean getUserEmail(String email);

	// for signIn use @PathVariable
	public String signIn(String email, String userPassword);

	public String save(Users user);

	public Optional<Users> getDetailsByUserId(Integer id);

}
