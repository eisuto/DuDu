package com.poi.dudu.controller;

import java.util.List;

import com.poi.dudu.base.Response;
import com.poi.dudu.domain.Role;
import com.poi.dudu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色Controller
 *
 * @author eisuto
 * @date 2021-04-07
 */
@RestController
@RequestMapping("/api/system/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 查询角色列表
     */

    @GetMapping("/list")
    public Response list(Role role) {
        Response response = new Response();
        response.setData(roleService.selectRoleList(role));
        return response;
    }


    /**
     * 获取角色详细信息
     */
    @GetMapping(value = "/{id}")
    public Response getInfo(@PathVariable("id") Long id) {
        Response response = new Response();
        response.setData(roleService.selectRoleById(id));
        return response;
    }

    /**
     * 新增角色
     */
    @PostMapping
    public Response add(@RequestBody Role role) {
        Response response = new Response();
        response.setData(roleService.insertRole(role));
        return response;
    }

    /**
     * 修改角色
     */
    @PutMapping
    public Response edit(@RequestBody Role role) {
        Response response = new Response();
        response.setData(roleService.updateRole(role));
        return response;
    }

    /**
     * 删除角色
     */
    @DeleteMapping("/{ids}")
    public Response remove(@PathVariable Long[] ids) {
        roleService.deleteRoleByIds(ids);
        return new Response();
    }
}
