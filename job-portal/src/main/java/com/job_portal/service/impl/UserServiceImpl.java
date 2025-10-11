package com.job_portal.service.impl;

import com.job_portal.exception.ResourceNotFoundException;
import com.job_portal.model.User;
import com.job_portal.repository.UserRepository;
import com.job_portal.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User entity) {
        logger.info("Saving User: {}", entity);
        return repository.save(entity);
    }

    @Override
    public User getById(Integer id) {
        logger.info("Fetching User by id: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<User> getAll() {
        logger.info("Fetching all Users");
        return repository.findAll();
    }

    @Override
    public User update(Integer id, User entity) {
        logger.info("Updating User id: {} with data: {}", id, entity);
        User existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        entity.setUserId(id);
        return repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        logger.info("Deleting User by id: {}", id);
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
