package com.scheculerpoint.scheculerpoint.service;

import com.scheculerpoint.scheculerpoint.domain.Movimentation;
import com.scheculerpoint.scheculerpoint.repository.MovimentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentationService {

    @Autowired
    private MovimentationRepository repository;

    public Optional<Movimentation> findById(Long id) {
        return repository.findById(id);
    }

    public List<Movimentation> findAll() {
        return repository.findAll();
    }

    public Movimentation save(Movimentation movimentation) {
        return repository.save(movimentation);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public Movimentation update(Movimentation movimentation) {
        return repository.save(movimentation);
    }
}
