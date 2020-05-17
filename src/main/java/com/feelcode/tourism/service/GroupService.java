package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.Group;
import com.feelcode.tourism.entity.GroupRequestPageDTO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 21:48 2020/5/16
 * @Modified By:
 */
public interface GroupService {
    Group save(Group group);

    Group findById(String id);

    void delete(Group group);

    List<Group> findAll();

    Page<Group> findAllByPage(GroupRequestPageDTO request);

    Long findAllByCount();
}
