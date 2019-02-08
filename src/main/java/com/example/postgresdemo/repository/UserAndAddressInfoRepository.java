package com.example.postgresdemo.repository;

import com.example.postgresdemo.entity.AddressAndUserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserAndAddressInfoRepository extends CrudRepository<AddressAndUserInfo, String> {
}
