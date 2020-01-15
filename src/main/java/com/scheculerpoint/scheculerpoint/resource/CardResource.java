package com.scheculerpoint.scheculerpoint.resource;

import com.scheculerpoint.scheculerpoint.domain.Card;
import com.scheculerpoint.scheculerpoint.service.CardService;
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
@RequestMapping("cards")
public class CardResource {

    @Autowired
    private CardService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Card> findById(@PathVariable Long id) {
        Optional<Card> category = service.findById(id);
        if(category.isPresent())
            return new ResponseEntity<>(category.get(), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Card>> findAll() {
        List<Card> card = service.findAll();
        if(card.isEmpty())
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);

        return ResponseEntity.ok().body(card);
    }

    @PostMapping
    public ResponseEntity<Card> save(@RequestBody @Valid Card card) {
        card = service.save(card);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(card.getId()).toUri();
        return ResponseEntity.created(uri).body(card);
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
        Optional<Card> card = service.findById(id);
        if(card.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> update(@PathVariable Long id, @RequestBody @Valid Card cardModified) {
        Optional<Card> result = service.findById(id);
        if(result.isPresent()) {
            service.update(cardModified);
            return ResponseEntity.ok().body(cardModified);
        }
        return ResponseEntity.notFound().build();
    }
}
