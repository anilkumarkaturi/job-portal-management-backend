package com.job_portal.service;

import com.job_portal.model.User;
import java.util.List;

public interface UserService {
    User save(User entity);
    User getById(Integer id);
    List<User> getAll();
    User update(Integer id, User entity);
    void delete(Integer id);
}

