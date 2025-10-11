package com.job_portal.repository;
import com.job_portal.model.JobLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobLocationRepository extends JpaRepository<JobLocation, Integer> {
}
