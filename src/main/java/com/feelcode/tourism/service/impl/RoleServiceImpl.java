package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.RoleDao;
import com.feelcode.tourism.dao.UserRoleDao;
import com.feelcode.tourism.entity.Role;
import com.feelcode.tourism.entity.UserRole;
import com.feelcode.tourism.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:17 2021/4/7
 * @Modified By:
 */
@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleDao roleDao;
    @Resource
    UserRoleDao userRoleDao;

    @Override
    public Role save(Role role) {
        return roleDao.save(role);
    }

    @Override
    public UserRole saveUserRole(UserRole userRole) {
        return userRoleDao.save(userRole);
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public Role findByName(String name) {
        return roleDao.findByName(name);
    }

    @Override
    public UserRole findByUserId(String userId) {
        return userRoleDao.findByUserId(userId);
    }

    @Override
    public void delete(Role role) {
        roleDao.delete(role);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

//    @Override
//    public Page<Role> findAllByPage(RoleRequestPageDTO request) {
//        // 排序方式，这里是以“recordNo”为标准进行降序
//        Sort sort = new Sort(Sort.Direction.DESC, "createDate");  // 这里的"recordNo"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
//        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort); // （当前页， 每页记录数， 排序方式）
//        return roleDao.findAll(pageable);
//    }

    @Override
    public Long findAllByCount() {
        return roleDao.count();
    }
}
