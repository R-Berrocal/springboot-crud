package com.roberto.curso.springboot.app.springboot_crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roberto.curso.springboot.app.springboot_crud.entities.Role;
import com.roberto.curso.springboot.app.springboot_crud.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAllRoles() {
        return (List<Role>) roleRepository.findAll();
    }

}
