package com.example.postgresdemo.repository;

import com.example.postgresdemo.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, String> {
}
