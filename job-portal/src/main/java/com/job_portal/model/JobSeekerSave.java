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

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "job_post_id")
    private JobPostActivity jobPostActivity;

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "user_id")
    private User user;


}
