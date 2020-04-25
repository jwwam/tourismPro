package com.feelcode.tourism.dao;

import com.feelcode.tourism.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDao extends PagingAndSortingRepository<User, Long>,JpaSpecificationExecutor<User>,JpaRepository<User,Long> {
    User findById(String id);
}
