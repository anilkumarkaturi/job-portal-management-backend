package com.job_portal.controller;

import com.job_portal.model.JobSeekerApply;
import com.job_portal.repository.JobSeekerApplyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/job-seeker-applies")
public class JobSeekerApplyController {
    private final JobSeekerApplyRepository repository;

    public JobSeekerApplyController(JobSeekerApplyRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public JobSeekerApply create(@RequestBody JobSeekerApply entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobSeekerApply> getById(@PathVariable Integer id) {
        Optional<JobSeekerApply> entity = repository.findById(id);
        return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<JobSeekerApply> getAll() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobSeekerApply> update(@PathVariable Integer id, @RequestBody JobSeekerApply updated) {
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

