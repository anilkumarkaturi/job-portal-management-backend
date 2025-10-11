package com.job_portal.service.impl;

import com.job_portal.exception.ResourceNotFoundException;
import com.job_portal.model.JobSeekerProfile;
import com.job_portal.repository.JobSeekerProfileRepository;
import com.job_portal.service.JobSeekerProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerProfileServiceImpl implements JobSeekerProfileService {
    private final JobSeekerProfileRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(JobSeekerProfileServiceImpl.class);

    public JobSeekerProfileServiceImpl(JobSeekerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public JobSeekerProfile save(JobSeekerProfile entity) {
        logger.info("Saving JobSeekerProfile: {}", entity);
        return repository.save(entity);
    }

    @Override
    public JobSeekerProfile getById(Integer id) {
        logger.info("Fetching JobSeekerProfile by id: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobSeekerProfile not found with id: " + id));
    }

    @Override
    public List<JobSeekerProfile> getAll() {
        logger.info("Fetching all JobSeekerProfiles");
        return repository.findAll();
    }

    @Override
    public JobSeekerProfile update(Integer id, JobSeekerProfile entity) {
        logger.info("Updating JobSeekerProfile id: {} with data: {}", id, entity);
        JobSeekerProfile existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobSeekerProfile not found with id: " + id));
        entity.setUserAccountId(id);
        return repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        logger.info("Deleting JobSeekerProfile by id: {}", id);
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("JobSeekerProfile not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
