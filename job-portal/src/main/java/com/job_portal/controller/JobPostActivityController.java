package com.job_portal.controller;

import com.job_portal.model.JobPostActivity;
import com.job_portal.repository.JobPostActivityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/job-post-activities")
public class JobPostActivityController {
    private final JobPostActivityRepository repository;

    public JobPostActivityController(JobPostActivityRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public JobPostActivity create(@RequestBody JobPostActivity entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPostActivity> getById(@PathVariable Integer id) {
        Optional<JobPostActivity> entity = repository.findById(id);
        return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<JobPostActivity> getAll() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPostActivity> update(@PathVariable Integer id, @RequestBody JobPostActivity updated) {
        return repository.findById(id)
                .map(existing -> {
                    updated.setJobPostId(id);
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
