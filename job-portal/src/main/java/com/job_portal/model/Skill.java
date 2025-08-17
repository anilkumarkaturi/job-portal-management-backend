package com.job_portal.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "skills")
@Entity
@Data
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "experience_level")
    private String experienceLevel;

    @Column(name = "name")
    private String name;

    @Column(name = "years_of_experience")
    private String yearsOfExperience;

    @Column(name = "job_seeker_profile")
    private String jobSeekerProfile;

}
