package com.job_portal.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="job_location")
@Entity
@Data
public class JobLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    private String country;
    private String state;
}
