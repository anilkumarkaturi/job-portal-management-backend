package com.job_portal.service.impl;

import com.job_portal.exception.ResourceNotFoundException;
import com.job_portal.model.JobPostActivity;
import com.job_portal.repository.JobPostActivityRepository;
import com.job_portal.service.JobPostActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostActivityServiceImpl implements JobPostActivityService {
    private final JobPostActivityRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(JobPostActivityServiceImpl.class);

    public JobPostActivityServiceImpl(JobPostActivityRepository repository) {
        this.repository = repository;
    }

    @Override
    public JobPostActivity save(JobPostActivity entity) {
        logger.info("Saving JobPostActivity: {}", entity);
        return repository.save(entity);
    }

    @Override
    public JobPostActivity getById(Integer id) {
        logger.info("Fetching JobPostActivity by id: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobPostActivity not found with id: " + id));
    }

    @Override
    public List<JobPostActivity> getAll() {
        logger.info("Fetching all JobPostActivities");
        return repository.findAll();
    }

    @Override
    public JobPostActivity update(Integer id, JobPostActivity entity) {
        logger.info("Updating JobPostActivity id: {} with data: {}", id, entity);
        JobPostActivity existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobPostActivity not found with id: " + id));
        entity.setJobPostId(id);
        return repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        logger.info("Deleting JobPostActivity by id: {}", id);
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("JobPostActivity not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
