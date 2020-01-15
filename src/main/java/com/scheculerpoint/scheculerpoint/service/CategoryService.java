package com.scheculerpoint.scheculerpoint.service;

import com.scheculerpoint.scheculerpoint.domain.Category;
import com.scheculerpoint.scheculerpoint.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category save(Category category) {
        return repository.save(category);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public Category update(Category category) {
        return repository.save(category);
    }
}
