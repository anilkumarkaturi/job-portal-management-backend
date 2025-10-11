package com.job_portal.service;

import com.job_portal.model.UserType;
import java.util.List;

public interface UserTypeService {
    UserType save(UserType entity);
    UserType getById(Integer id);
    List<UserType> getAll();
    UserType update(Integer id, UserType entity);
    void delete(Integer id);
}

