package com.scheculerpoint.scheculerpoint.service;

import com.scheculerpoint.scheculerpoint.domain.Card;
import com.scheculerpoint.scheculerpoint.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository repository;

    public Optional<Card> findById(Long id) {
        return repository.findById(id);
    }

    public List<Card> findAll() {
        return repository.findAll();
    }

    public Card save(Card card) {
        return repository.save(card);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public Card update(Card card) {
        return repository.save(card);
    }
}
