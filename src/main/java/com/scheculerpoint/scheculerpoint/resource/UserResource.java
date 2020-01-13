package com.scheculerpoint.scheculerpoint.resource;

import com.scheculerpoint.scheculerpoint.domain.User;
import com.scheculerpoint.scheculerpoint.service.UserService;
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
@RequestMapping("users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> user = service.findById(id);
        if(user.isPresent())
            return new ResponseEntity<>(user.get(), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAll();
        if(users.isEmpty())
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);

        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid User user) {
        user = service.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping
    public ResponseEntity deleteAll() {
        if(!service.findAll().isEmpty()) {
            service.deleteAll();
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/admin")
    public ResponseEntity<User> findAdmin() {
        User admin = service.findAdmin();
        HttpStatus status = admin == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<>(admin, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        Optional<User> user = service.findById(id);
        if(user.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody @Valid User userModified) {
        Optional<User> result = service.findById(id);
        if(result.isPresent()) {
            service.update(userModified);
            return ResponseEntity.ok().body(userModified);
        }
        return ResponseEntity.notFound().build();
    }
}
