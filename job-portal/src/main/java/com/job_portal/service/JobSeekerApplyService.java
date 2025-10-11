package com.job_portal.service;

import com.job_portal.model.JobSeekerApply;
import java.util.List;

public interface JobSeekerApplyService {
    JobSeekerApply save(JobSeekerApply entity);
    JobSeekerApply getById(Integer id);
    List<JobSeekerApply> getAll();
    JobSeekerApply update(Integer id, JobSeekerApply entity);
    void delete(Integer id);
}

