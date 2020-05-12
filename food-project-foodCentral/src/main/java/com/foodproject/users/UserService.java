package com.foodproject.users;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService implements UsersInterface {

	@Autowired
	UsersRepository repo;

	// =========================================================

	@Autowired
	RestTemplate restTemplate;

	@Override
	public String signUp(Users user) {
		
		if (getUserEmail(user.getEmail())) {
			return "email exists";
		} else {
			// here we will call 2FA micro service and we will save the details in db from
			// 2FA microservice
			// we will have to remove repo.save()we
			// repo.save(user);
			String url = "http://localhost:8081/fa/auth";
			return restTemplate.postForObject(url, user, String.class);

		}
	}

	@Override
	public boolean getUserEmail(String email) {
		
		int e = repo.getUserByEmail(email);
		if (e >= 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String signIn(String email, String userPassword) {
		
		return (repo.getUserByCred(email, userPassword) > 0
				? "Login Successful!" : "Login Failed!" );
		
//				? "{\"response\":\"Login Successfull!\"}" : "{\"response\":\"Login Failed!\"}");
				
	}

	@Override
	public Optional<Users> getDetailsByUserId(Integer id) {
		return repo.findById(id);
	}

	@Override
	public String save(Users user) {

		return (repo.save(user) != null ? "User Sign-up Successfull !" : "Something went wrong while saving your data! Please try again...");
			
	}
	
	

	// =========================================================
	
	
//	new method
	public Optional<Users> getUserDetailsByEmail(String email) {
		
		return repo.findByEmail(email);
	}


	public String deleteUserById(Integer id) {
		
		if(repo.existsById(id) == true) {
			repo.deleteById(id);
			return "User Has been removed successfully!"; 
		}
		else {
			return "User doesn't exist!";
		}
	}

}
