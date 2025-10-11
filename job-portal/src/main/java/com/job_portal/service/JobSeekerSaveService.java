package com.job_portal.service;

import com.job_portal.model.JobSeekerSave;
import java.util.List;

public interface JobSeekerSaveService {
    JobSeekerSave save(JobSeekerSave entity);
    JobSeekerSave getById(Integer id);
    List<JobSeekerSave> getAll();
    JobSeekerSave update(Integer id, JobSeekerSave entity);
    void delete(Integer id);
}

