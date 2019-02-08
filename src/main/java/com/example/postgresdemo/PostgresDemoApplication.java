package com.example.postgresdemo;

import com.example.postgresdemo.entity.Address;
import com.example.postgresdemo.entity.AddressAndUserInfo;
import com.example.postgresdemo.entity.UserInfo;
import com.example.postgresdemo.repository.UserAndAddressInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PostgresDemoApplication {

	@Autowired
	private UserAndAddressInfoRepository userAndAddressInfoRepository;

	public static void main(String[] args) {
		SpringApplication.run(PostgresDemoApplication.class, args);
	}

	public void run(String... args) throws Exception{
		UserInfo userInfo = new UserInfo();
		userInfo.setName("name");

		Address address = new Address();
		address.setLine1("line1");

		AddressAndUserInfo addressAndUserInfo = new AddressAndUserInfo();
		addressAndUserInfo.setAddress(address);
		addressAndUserInfo.setUserInfo(userInfo);

		addressAndUserInfo.setAddressAndUserInfoId("1");
		userAndAddressInfoRepository.save(addressAndUserInfo);
	}
}
