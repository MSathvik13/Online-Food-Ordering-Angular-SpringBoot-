package com.food.fa.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.food.fa.dto.OtpDetail;

@Repository
public interface OtpDetailRepository extends CrudRepository<OtpDetail, Integer> {

	@Query(value = "SELECT count(*) FROM otp_detail WHERE email=?1 AND otp_gen= ?2", nativeQuery = true)
	int validate(String email, String otpValue);

	@Query(value = "SELECT otpid FROM otp_detail WHERE email=?1", nativeQuery = true)
	Integer getId(String email);

	@Query(value = "SELECT name FROM otp_detail WHERE email=?1 AND otp_gen=?2", nativeQuery = true)
	String getName(String email, String otpValue);

	@Query(value = "SELECT password FROM otp_detail WHERE email=?1 AND otp_gen=?2", nativeQuery = true)
	String getPassword(String email, String otpValue);
	
	@Query(value = "SELECT timestamp FROM otp_detail WHERE email=?1 AND otp_gen=?2", nativeQuery = true)
	long getTimeStamp(String email, String otp_gen);
	
//	edit below..-----------------------------------------------------------------------------------------------------------------------------
	
	@Query(value = "SELECT door_no FROM otp_detail WHERE email=?1 AND otp_gen=?2", nativeQuery = true)
	String getDoorNo(String email, String otpValue);
	
	@Query(value = "SELECT locality FROM otp_detail WHERE email=?1 AND otp_gen=?2", nativeQuery = true)
	String getLocality(String email, String otpValue);
	
	@Query(value = "SELECT city FROM otp_detail WHERE email=?1 AND otp_gen=?2", nativeQuery = true)
	String getCity(String email, String otpValue);
	
	@Query(value = "SELECT user_phone FROM otp_detail WHERE email=?1 AND otp_gen=?2", nativeQuery = true)
	String getUserPhone(String email, String otpValue);
	
//	edit above..-----------------------------------------------------------------------------------------------------------------------------
	
}
