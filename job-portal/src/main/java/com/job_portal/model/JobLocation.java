package com.job_portal.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "job_location")
@Entity
@Data
public class JobLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;
}
