package com.food.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.food.fa.dto.Users;
import com.food.fa.service.OtpService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/fa")
@Api(value = "Service Rest API", description = "Information about the profiles that are being provided in the organization")
public class OtpController {
	
	@ApiModelProperty(notes = "autowired service for this api")
	@Autowired
	OtpService service;

	@ApiOperation(value = "to send a mail", notes = "Hit this URL for getting an mail")
	@RequestMapping(method = RequestMethod.POST, value = "/auth")
	String authenticate(@RequestBody Users user) { 
		
		return service.sendAuthMail(user);
		
	}

	@ApiOperation(value = "getting OTP through Mail ", notes = "Hit this URL for getting an otp through mail")
	@RequestMapping("/verify/{email}/{otp_gen}")
	String validate(@PathVariable String email, @PathVariable String otp_gen) {

		return service.verifyLink(email, otp_gen);
	}
}