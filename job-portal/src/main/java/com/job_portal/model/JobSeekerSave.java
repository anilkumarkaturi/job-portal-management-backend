package com.job_portal.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "job_seeker_save")
@Entity
@Data
public class JobSeekerSave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "job")
    private JobPostActivity jobPostActivity;

    @Column(name = "user_id")
    private User user;


}
