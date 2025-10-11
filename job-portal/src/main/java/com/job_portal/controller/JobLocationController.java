package com.job_portal.controller;

import com.job_portal.model.JobLocation;
import com.job_portal.service.JobLocationService;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/job-locations")
public class JobLocationController {

    private final JobLocationService jobLocationService;

    public JobLocationController(JobLocationService jobLocationService) {
        this.jobLocationService = jobLocationService;
    }

    @PostMapping("/random")
    public JobLocation createRandomJobLocation() {
        return jobLocationService.saveRandomJobLocation();
    }
}
