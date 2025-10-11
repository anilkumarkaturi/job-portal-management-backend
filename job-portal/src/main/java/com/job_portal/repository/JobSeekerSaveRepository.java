package com.job_portal.repository;

import com.job_portal.model.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Integer> {
}