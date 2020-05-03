package com.feelcode.tourism.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserResponsePageDTO extends CommonResponsePageDTO{
    private List<User> userList;
}
