package com.job_portal.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "recruiter_profile")
@Entity
@Data
public class RecruiterProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_account_id")
    private Integer userAccountId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @MapsId
    private User userId;

    @Column(name = "city")
    private String city;


    @Column(name = "company")
    private String company;



    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

}
