package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.GroupDao;
import com.feelcode.tourism.entity.Group;
import com.feelcode.tourism.entity.GroupRequestPageDTO;
import com.feelcode.tourism.service.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 21:49 2020/5/16
 * @Modified By:
 */
@Service(value = "groupService")
public class GroupServiceImpl implements GroupService {

    @Resource
    GroupDao groupDao;

    @Override
    public Group save(Group group) {
        return groupDao.save(group);
    }

    @Override
    public Group findById(String id) {
        return groupDao.findById(id);
    }

    @Override
    public void delete(Group group) {
        groupDao.delete(group);
    }

    @Override
    public List<Group> findAll() {
        return groupDao.findAll();
    }

    @Override
    public Page<Group> findAllByPage(GroupRequestPageDTO request) {
        // 排序方式，这里是以“recordNo”为标准进行降序
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");  // 这里的"recordNo"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort); // （当前页， 每页记录数， 排序方式）
        return groupDao.findAll(pageable);
    }

    @Override
    public Long findAllByCount() {
        return groupDao.count();
    }
}
