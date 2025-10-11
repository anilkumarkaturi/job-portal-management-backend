package com.job_portal.service;

import com.job_portal.model.JobLocation;
import com.job_portal.repository.JobLocationRepository;
import org.springframework.stereotype.Service;

@Service
public class JobLocationService {

    private final JobLocationRepository jobLocationRepository;

    public JobLocationService(JobLocationRepository jobLocationRepository) {
        this.jobLocationRepository = jobLocationRepository;
    }

    public JobLocation saveRandomJobLocation() {
        JobLocation jobLocation = new JobLocation();
        jobLocation.setCity("New York");
        jobLocation.setState("NY");
        jobLocation.setCountry("USA");
        return jobLocationRepository.save(jobLocation);
    }
}
