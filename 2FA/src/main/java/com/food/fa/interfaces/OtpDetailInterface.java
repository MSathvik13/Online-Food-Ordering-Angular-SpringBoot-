package com.food.fa.interfaces;

import com.food.fa.dto.Users;

public interface OtpDetailInterface {

	public String sendAuthMail(Users user);

	public String verifyLink(String email, String otpValue);
}
