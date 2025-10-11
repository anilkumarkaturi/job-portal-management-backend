package com.job_portal.service;

import com.job_portal.model.JobPostActivity;
import java.util.List;

public interface JobPostActivityService {
    JobPostActivity save(JobPostActivity entity);
    JobPostActivity getById(Integer id);
    List<JobPostActivity> getAll();
    JobPostActivity update(Integer id, JobPostActivity entity);
    void delete(Integer id);
}

