package com.example.postgresdemo.repository;

import com.example.postgresdemo.entity.Address;
import com.example.postgresdemo.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

}
