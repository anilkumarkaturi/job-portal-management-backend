package com.job_portal.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Table(name="job_post_activity")
@Entity
@Data
public class JobPostActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="job_post_id")
    private Integer jobPostId;
    @Column(name="description_of_job")
    private String descriptionOfJob;
    @Column(name ="job_title")
    private String jobTitle;
    @Column(name ="job_type")
    private String jobType;
    @Column(name ="posted_date")
    private Date postedDate;
    @Column(name="remote")
    private String remote;
    @Column(name="salary")
    private String salary;
    @Column(name="job_company_id")
    private Integer jobCompanyId;
    @Column(name="job_location_id")
    private Integer jobLocationId;
    @Column(name="post_by_id")
    private Integer postById;
}
