package com.job_portal.service.impl;

import com.job_portal.exception.ResourceNotFoundException;
import com.job_portal.model.RecruiterProfile;
import com.job_portal.repository.RecruiterProfileRepository;
import com.job_portal.service.RecruiterProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterProfileServiceImpl implements RecruiterProfileService {
    private final RecruiterProfileRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(RecruiterProfileServiceImpl.class);

    public RecruiterProfileServiceImpl(RecruiterProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public RecruiterProfile save(RecruiterProfile entity) {
        logger.info("Saving RecruiterProfile: {}", entity);
        return repository.save(entity);
    }

    @Override
    public RecruiterProfile getById(Integer id) {
        logger.info("Fetching RecruiterProfile by id: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecruiterProfile not found with id: " + id));
    }

    @Override
    public List<RecruiterProfile> getAll() {
        logger.info("Fetching all RecruiterProfiles");
        return repository.findAll();
    }

    @Override
    public RecruiterProfile update(Integer id, RecruiterProfile entity) {
        logger.info("Updating RecruiterProfile id: {} with data: {}", id, entity);
        RecruiterProfile existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecruiterProfile not found with id: " + id));
        entity.setUserAccountId(id);
        return repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        logger.info("Deleting RecruiterProfile by id: {}", id);
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("RecruiterProfile not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
