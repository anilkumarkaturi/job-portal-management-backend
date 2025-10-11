package com.job_portal.controller;

import com.job_portal.model.JobSeekerSave;
import com.job_portal.repository.JobSeekerSaveRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/job-seeker-saves")
public class JobSeekerSaveController {
    private final JobSeekerSaveRepository repository;

    public JobSeekerSaveController(JobSeekerSaveRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public JobSeekerSave create(@RequestBody JobSeekerSave entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobSeekerSave> getById(@PathVariable Integer id) {
        Optional<JobSeekerSave> entity = repository.findById(id);
        return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<JobSeekerSave> getAll() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobSeekerSave> update(@PathVariable Integer id, @RequestBody JobSeekerSave updated) {
        return repository.findById(id)
                .map(existing -> {
                    updated.setId(id);
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

