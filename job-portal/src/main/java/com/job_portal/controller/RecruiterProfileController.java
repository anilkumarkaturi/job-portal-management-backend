package com.job_portal.controller;

import com.job_portal.model.RecruiterProfile;
import com.job_portal.repository.RecruiterProfileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recruiter-profiles")
public class RecruiterProfileController {
    private final RecruiterProfileRepository repository;

    public RecruiterProfileController(RecruiterProfileRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public RecruiterProfile create(@RequestBody RecruiterProfile entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecruiterProfile> getById(@PathVariable Integer id) {
        Optional<RecruiterProfile> entity = repository.findById(id);
        return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<RecruiterProfile> getAll() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecruiterProfile> update(@PathVariable Integer id, @RequestBody RecruiterProfile updated) {
        return repository.findById(id)
                .map(existing -> {
                    updated.setUserAccountId(id);
                    return ResponseEntity.ok(repository.save(updated));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

