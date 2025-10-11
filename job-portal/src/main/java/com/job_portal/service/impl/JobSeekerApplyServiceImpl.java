package com.job_portal.service.impl;

import com.job_portal.exception.ResourceNotFoundException;
import com.job_portal.model.JobSeekerApply;
import com.job_portal.repository.JobSeekerApplyRepository;
import com.job_portal.service.JobSeekerApplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerApplyServiceImpl implements JobSeekerApplyService {
    private final JobSeekerApplyRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(JobSeekerApplyServiceImpl.class);

    public JobSeekerApplyServiceImpl(JobSeekerApplyRepository repository) {
        this.repository = repository;
    }

    @Override
    public JobSeekerApply save(JobSeekerApply entity) {
        logger.info("Saving JobSeekerApply: {}", entity);
        return repository.save(entity);
    }

    @Override
    public JobSeekerApply getById(Integer id) {
        logger.info("Fetching JobSeekerApply by id: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobSeekerApply not found with id: " + id));
    }

    @Override
    public List<JobSeekerApply> getAll() {
        logger.info("Fetching all JobSeekerApply records");
        return repository.findAll();
    }

    @Override
    public JobSeekerApply update(Integer id, JobSeekerApply entity) {
        logger.info("Updating JobSeekerApply id: {} with data: {}", id, entity);
        JobSeekerApply existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobSeekerApply not found with id: " + id));
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        logger.info("Deleting JobSeekerApply by id: {}", id);
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("JobSeekerApply not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
