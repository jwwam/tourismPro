package com.feelcode.tourism.service.impl;

import com.feelcode.tourism.dao.PermissionDao;
import com.feelcode.tourism.dao.RolePermissionDao;
import com.feelcode.tourism.entity.Permission;
import com.feelcode.tourism.entity.RolePermission;
import com.feelcode.tourism.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 22:17 2021/4/7
 * @Modified By:
 */
@Service(value = "permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Resource
    PermissionDao permissionDao;
    @Resource
    RolePermissionDao rolePermissionDao;

    @Override
    public Permission save(Permission permission) {
        return permissionDao.save(permission);
    }

    @Override
    public Permission findById(String id) {
        return permissionDao.findById(id);
    }

    @Override
    public List<RolePermission> findByRoleId(String roleId) {
        return rolePermissionDao.findByRoleId(roleId);
    }

    @Override
    public void delete(Permission permission) {
        permissionDao.delete(permission);
    }

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

//    @Override
//    public Page<Permission> findAllByPage(PermissionRequestPageDTO request) {
//        // 排序方式，这里是以“recordNo”为标准进行降序
//        Sort sort = new Sort(Sort.Direction.DESC, "createDate");  // 这里的"recordNo"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
//        Pageable pageable = new PageRequest(request.getStart(), request.getLength(), sort); // （当前页， 每页记录数， 排序方式）
//        return permissionDao.findAll(pageable);
//    }

    @Override
    public Long findAllByCount() {
        return permissionDao.count();
    }
}
