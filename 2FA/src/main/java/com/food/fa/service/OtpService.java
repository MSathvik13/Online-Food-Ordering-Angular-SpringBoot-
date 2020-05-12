	package com.food.fa.service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.food.fa.dto.Users;
import com.food.fa.dto.OtpDetail;
import com.food.fa.interfaces.OtpDetailInterface;
import com.food.fa.interfaces.OtpDetailRepository;
import com.food.fa.util.SendMail;

@Service
public class OtpService implements OtpDetailInterface {

	@Autowired
	OtpDetailRepository repo;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public String sendAuthMail(Users user) {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		OtpDetail otp = new OtpDetail();

//		to insert data from POST request JSON Object to "otp_detail" table... 
		otp.setEmail(user.getEmail());
		otp.setName(user.getUserName());
		otp.setPassword(user.getUserPassword());
		
//		edit above..--------------------------------
		otp.setDoor_no(user.getDoor_no());
		otp.setLocality(user.getLocality());
		otp.setCity(user.getCity());
		otp.setUserPhone(user.getUserPhone());
//		edit above..---------------------------------
		
		long currenTime = timestamp.getTime();
		otp.setTimestamp(currenTime);

		Random random = new Random();

		otp.setOtpGen("" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10));

		if (repo.save(otp) == null) {

			return "Something went wrong";

		} else {

			// add the content to be sent
			return SendMail.send(user.getEmail(),
					"http://localhost:8081/fa/verify/" + otp.getEmail() + "/" + otp.getOtpGen(), otp.getName());
		}
	}
	

	@Override
	public String verifyLink(String email, String otpValue) {

		int check = repo.validate(email, otpValue);

		if (check >= 1) {

			String url = "http://localhost:8080/user/save";
			
			Integer otpid = repo.getId(email);

			Users user = new Users();

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			// 60000*10 is 1 min*10

			if (timestamp.getTime() > (repo.getTimeStamp(email, otpValue) + 600000)) {

				repo.deleteById(otpid);
				return "This OTP has Expired, Sign-up Again to Generate a New OTP";

			} else {
				
//				to insert data from "otp_detail" table to "users" table in database AFTER user email verification...
				user.setEmail(email);
				user.setUserName(repo.getName(email, otpValue));
				user.setUserPassword(repo.getPassword(email, otpValue));
				
//				edit below..-----------------------------------------------------------------------------------------------------------------------------
				
				user.setDoor_no(repo.getDoorNo(email, otpValue));
				user.setLocality(repo.getLocality(email, otpValue));
				user.setCity(repo.getCity(email, otpValue));
				user.setUserPhone(repo.getUserPhone(email, otpValue));
				
//				edit above..-----------------------------------------------------------------------------------------------------------------------------

//				deleting temporary data from "otp_detail" table once the data has been stored in actual "users" table after email verification...
				repo.deleteById(otpid);
				
				return restTemplate.postForObject(url, user, String.class);

			}

		} else {

			return "This link has either Expired or is Invalid!";

		}
	}

}

