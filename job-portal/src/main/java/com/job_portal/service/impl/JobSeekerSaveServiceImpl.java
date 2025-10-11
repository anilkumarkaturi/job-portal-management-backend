package com.job_portal.service.impl;

import com.job_portal.exception.ResourceNotFoundException;
import com.job_portal.model.JobSeekerSave;
import com.job_portal.repository.JobSeekerSaveRepository;
import com.job_portal.service.JobSeekerSaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerSaveServiceImpl implements JobSeekerSaveService {
    private final JobSeekerSaveRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(JobSeekerSaveServiceImpl.class);

    public JobSeekerSaveServiceImpl(JobSeekerSaveRepository repository) {
        this.repository = repository;
    }

    @Override
    public JobSeekerSave save(JobSeekerSave entity) {
        logger.info("Saving JobSeekerSave: {}", entity);
        return repository.save(entity);
    }

    @Override
    public JobSeekerSave getById(Integer id) {
        logger.info("Fetching JobSeekerSave by id: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobSeekerSave not found with id: " + id));
    }

    @Override
    public List<JobSeekerSave> getAll() {
        logger.info("Fetching all JobSeekerSave records");
        return repository.findAll();
    }

    @Override
    public JobSeekerSave update(Integer id, JobSeekerSave entity) {
        logger.info("Updating JobSeekerSave id: {} with data: {}", id, entity);
        JobSeekerSave existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobSeekerSave not found with id: " + id));
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        logger.info("Deleting JobSeekerSave by id: {}", id);
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("JobSeekerSave not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
