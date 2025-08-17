package com.job_portal.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Table(name="job_seeker_apply")
@Entity
@Data
public class JobSeekerApply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="apply_date")
    private Date applyDate;
    @Column(name="cover_letter")
    private String coverLetter;
    @Column(name="job")
    private Integer job;
    @Column(name="user_id")
    private Integer userId;
}
