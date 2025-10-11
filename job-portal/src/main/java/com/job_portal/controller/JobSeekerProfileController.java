package com.job_portal.controller;

import com.job_portal.model.JobSeekerProfile;
import com.job_portal.repository.JobSeekerProfileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/job-seeker-profiles")
public class JobSeekerProfileController {
    private final JobSeekerProfileRepository repository;

    public JobSeekerProfileController(JobSeekerProfileRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public JobSeekerProfile create(@RequestBody JobSeekerProfile entity) {
        return repository.save(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobSeekerProfile> getById(@PathVariable Integer id) {
        Optional<JobSeekerProfile> entity = repository.findById(id);
        return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<JobSeekerProfile> getAll() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobSeekerProfile> update(@PathVariable Integer id, @RequestBody JobSeekerProfile updated) {
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

