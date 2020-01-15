package com.scheculerpoint.scheculerpoint.resource;

import com.scheculerpoint.scheculerpoint.domain.Movimentation;
import com.scheculerpoint.scheculerpoint.service.MovimentationService;
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
@RequestMapping("movimentations")
public class MovimentationResource {

    @Autowired
    private MovimentationService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movimentation> findById(@PathVariable Long id) {
        Optional<Movimentation> movimentation = service.findById(id);
        if(movimentation.isPresent())
            return new ResponseEntity<>(movimentation.get(), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Movimentation>> findAll() {
        List<Movimentation> movimentation = service.findAll();
        if(movimentation.isEmpty())
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);

        return ResponseEntity.ok().body(movimentation);
    }

    @PostMapping
    public ResponseEntity<Movimentation> save(@RequestBody @Valid Movimentation movimentation) {
        movimentation = service.save(movimentation);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(movimentation.getId()).toUri();
        return ResponseEntity.created(uri).body(movimentation);
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
        Optional<Movimentation> movimentation = service.findById(id);
        if(movimentation.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimentation> update(@PathVariable Long id, @RequestBody @Valid Movimentation movimentationModified) {
        Optional<Movimentation> result = service.findById(id);
        if(result.isPresent()) {
            service.update(movimentationModified);
            return ResponseEntity.ok().body(movimentationModified);
        }
        return ResponseEntity.notFound().build();
    }
}
