package com.roberto.curso.springboot.app.springboot_crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roberto.curso.springboot.app.springboot_crud.entities.Role;
import com.roberto.curso.springboot.app.springboot_crud.entities.User;
import com.roberto.curso.springboot.app.springboot_crud.repositories.RoleRepository;
import com.roberto.curso.springboot.app.springboot_crud.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    UserServiceImpl() {
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {

        Optional<Role> roleOptional = roleRepository.findByName("ROLE_USER");

        List<Role> roles = new ArrayList<>();

        roleOptional.ifPresent(roles::add);

        if (user.isAdmin()) {
            Optional<Role> roleAdminOptional = roleRepository.findByName("ROLE_ADMIN");
            roleAdminOptional.ifPresent(roles::add);
        }

        user.setRoles(roles);

        String passwordEncoded = passwordEncoder.encode(user.getPassword());

        user.setPassword(passwordEncoded);
        return userRepository.save(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

}
