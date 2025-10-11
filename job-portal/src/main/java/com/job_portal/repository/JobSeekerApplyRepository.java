package com.job_portal.repository;

import com.job_portal.model.JobSeekerApply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerApplyRepository extends JpaRepository<JobSeekerApply, Integer> {
}