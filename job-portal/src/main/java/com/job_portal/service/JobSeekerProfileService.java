package com.job_portal.service;

import com.job_portal.model.JobSeekerProfile;
import java.util.List;

public interface JobSeekerProfileService {
    JobSeekerProfile save(JobSeekerProfile entity);
    JobSeekerProfile getById(Integer id);
    List<JobSeekerProfile> getAll();
    JobSeekerProfile update(Integer id, JobSeekerProfile entity);
    void delete(Integer id);
}

