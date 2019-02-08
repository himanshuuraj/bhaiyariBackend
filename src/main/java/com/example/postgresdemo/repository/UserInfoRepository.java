package com.example.postgresdemo.repository;

import com.example.postgresdemo.entity.UserInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends PagingAndSortingRepository<UserInfo, String> {
}
