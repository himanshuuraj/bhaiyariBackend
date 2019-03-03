package com.example.postgresdemo.repository;

import com.example.postgresdemo.entity.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserInfoRepository extends PagingAndSortingRepository<UserInfo, String> {

//    @Query("select * from Address where username=?1 AND password = ?2");
//    List<UserInfo> findByCourseIdAndModuleIdIn(String username, String password);

    List<UserInfo> findByEmailAndPassword(String email, String password);

}
