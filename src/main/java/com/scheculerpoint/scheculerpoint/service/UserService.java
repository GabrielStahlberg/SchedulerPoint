package com.scheculerpoint.scheculerpoint.service;

import com.scheculerpoint.scheculerpoint.domain.User;
import com.scheculerpoint.scheculerpoint.domain.enumeration.EnumUserRole;
import com.scheculerpoint.scheculerpoint.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public User findAdmin() {
        return repository.findByLoginRole(EnumUserRole.ADMIN);
    }

    public User update(User user) {
        return repository.save(user);
    }
}
