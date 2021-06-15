package com.poi.dudu.service.impl;

import com.poi.dudu.domain.Role;
import com.poi.dudu.mapper.RoleRepository;
import com.poi.dudu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


/**
 * 角色Service业务层处理
 *
 * @author eisuto
 * @date 2021-04-07
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    /**
     * 查询角色
     *
     * @param id 角色ID
     * @return 角色
     */
    @Override
    public Role selectRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    /**
     * 查询角色列表
     *
     * @param role 角色
     * @return 角色集合
     */
    @Override
    public Page<Role> selectRoleList(Role role) {
//        //Repository
//        Page<Role> roles = roleRepository.findAll(null);
//        return roles;
        return null;
    }

    /**
     * 新增角色
     *
     * @param role 角色
     * @return 结果
     */
    @Override
    public boolean insertRole(Role role) {
        Role r = roleRepository.save(role);
        return r != null;
    }

    /**
     * 修改角色
     *
     * @param role 角色
     * @return 结果
     */
    @Override
    public boolean updateRole(Role role) {
        Role r = roleRepository.save(role);
        return r != null;
    }

    /**
     * 批量删除角色
     *
     * @param ids 需要删除的角色ID
     * @return 结果
     */
    @Override
    public void deleteRoleByIds(Long[] ids) {
        roleRepository.deleteByIdIn(ids);
    }

    /**
     * 删除角色信息
     *
     * @param id 角色ID
     * @return 结果
     */
    @Override
    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }
}

