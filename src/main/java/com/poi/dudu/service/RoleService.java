package com.poi.dudu.service;

import com.poi.dudu.domain.Role;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 角色Service接口
 *
 * @author eisuto
 * @date 2021-04-07
 */
public interface RoleService {
    /**
     * 查询角色
     *
     * @param id 角色ID
     * @return 角色
     */
    public Role selectRoleById(Long id);

    /**
     * 查询角色列表
     *
     * @param role 角色
     * @return 角色集合
     */
    public Page<Role> selectRoleList(Role role);

    /**
     * 新增角色
     *
     * @param role 角色
     * @return 结果
     */
    public boolean insertRole(Role role);

    /**
     * 修改角色
     *
     * @param role 角色
     * @return 结果
     */
    public boolean updateRole(Role role);

    /**
     * 批量删除角色
     *
     * @param ids 需要删除的角色ID
     * @return 结果
     */
    public void deleteRoleByIds(Long[] ids);

    /**
     * 删除角色信息
     *
     * @param id 角色ID
     * @return 结果
     */
    public void deleteRoleById(Long id);
}
