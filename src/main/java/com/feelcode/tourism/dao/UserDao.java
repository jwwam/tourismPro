package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDao extends PagingAndSortingRepository<User, Long>,JpaSpecificationExecutor<User>,JpaRepository<User,Long> {

    User findById(String id);

    User findByUserNameAndPassword(String userName, String password);

    User findByUserName(String userName);

    @Modifying(clearAutomatically = true)
    @Query(value = "update tourism_user u set u.password=?2 where u.id = ?1",nativeQuery = true)
    Integer changePassword(String userId, String password);

}
