package com.job_portal.service.impl;

import com.job_portal.exception.ResourceNotFoundException;
import com.job_portal.model.UserType;
import com.job_portal.repository.UserTypeRepository;
import com.job_portal.service.UserTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService {
    private final UserTypeRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(UserTypeServiceImpl.class);

    public UserTypeServiceImpl(UserTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserType save(UserType entity) {
        logger.info("Saving UserType: {}", entity);
        return repository.save(entity);
    }

    @Override
    public UserType getById(Integer id) {
        logger.info("Fetching UserType by id: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserType not found with id: " + id));
    }

    @Override
    public List<UserType> getAll() {
        logger.info("Fetching all UserTypes");
        return repository.findAll();
    }

    @Override
    public UserType update(Integer id, UserType entity) {
        logger.info("Updating UserType id: {} with data: {}", id, entity);
        UserType existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserType not found with id: " + id));
        entity.setUserTypeId(id);
        return repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        logger.info("Deleting UserType by id: {}", id);
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("UserType not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
