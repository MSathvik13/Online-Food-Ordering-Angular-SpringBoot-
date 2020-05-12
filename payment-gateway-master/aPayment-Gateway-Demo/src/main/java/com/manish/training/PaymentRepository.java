package com.manish.training;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.manish.training.Order;
import java.io.IOException;

public class PaymentRepository {
	//private static final Double billAmount;
	private static final String getUrl = "https://localhost:8080/get/userTotalAmount/18";
	public PaymentRepository() {
		
	}
	public void sendGet() throws IOException {
		URL obj = new URL(getUrl);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode );
		if(responseCode == HttpURLConnection.HTTP_OK) {
			Order or = new Order();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			Double response;
			
//			while((inputLine = in.readLine()) != null) {
//				response.append(inputLine);
//			}
			response = new Double(con.getContentType());
			or.setPrice(response);
			in.close();
			System.out.println(response);
		} else {
			System.out.println("Get request didn't work.");
		}
	}
}
