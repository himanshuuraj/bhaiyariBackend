package com.example.postgresdemo.repository;

import com.example.postgresdemo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtherRepository extends JpaRepository<Address, String> {
}
