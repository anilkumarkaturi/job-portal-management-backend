package com.job_portal.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "job_seeker_profile")
@Entity
@Data
public class JobSeekerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_account_id")
    private Integer userAccountId;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @Column(name = "resume")
    private String resume;

    @Column(name = "state")
    private String state;

    @Column(name = "work_authorization")
    private String workAuthorization;

}
