package com.roberto.curso.springboot.app.springboot_crud.services;

import java.util.List;

import com.roberto.curso.springboot.app.springboot_crud.entities.Role;

public interface RoleService {
    public List<Role> findAllRoles();
}
