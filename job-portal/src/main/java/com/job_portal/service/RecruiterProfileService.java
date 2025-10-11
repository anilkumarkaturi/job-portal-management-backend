package com.job_portal.service;

import com.job_portal.model.RecruiterProfile;
import java.util.List;

public interface RecruiterProfileService {
    RecruiterProfile save(RecruiterProfile entity);
    RecruiterProfile getById(Integer id);
    List<RecruiterProfile> getAll();
    RecruiterProfile update(Integer id, RecruiterProfile entity);
    void delete(Integer id);
}

