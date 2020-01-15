package com.scheculerpoint.scheculerpoint.resource;

import com.scheculerpoint.scheculerpoint.domain.Category;
import com.scheculerpoint.scheculerpoint.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Optional<Category> category = service.findById(id);
        if(category.isPresent())
            return new ResponseEntity<>(category.get(), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = service.findAll();
        if(categories.isEmpty())
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);

        return ResponseEntity.ok().body(categories);
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody @Valid Category category) {
        category = service.save(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(category);
    }

    @DeleteMapping
    public ResponseEntity deleteAll() {
        if(!service.findAll().isEmpty()) {
            service.deleteAll();
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        Optional<Category> category = service.findById(id);
        if(category.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody @Valid Category categoryModified) {
        Optional<Category> result = service.findById(id);
        if(result.isPresent()) {
            service.update(categoryModified);
            return ResponseEntity.ok().body(categoryModified);
        }
        return ResponseEntity.notFound().build();
    }
}
