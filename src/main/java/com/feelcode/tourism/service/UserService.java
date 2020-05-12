package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.User;
import com.feelcode.tourism.entity.UserRequestPageDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    User save(User user);

    User findById(String id);

    User findByUserNameAndPassword(String userName,String password);

    User findByUserName(String userName);

    void delete(User user);

    List<User> findAll();

    Page<User> findAllByPage(UserRequestPageDTO request);

    Long findAllByCount();
}
