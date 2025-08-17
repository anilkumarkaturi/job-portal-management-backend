package com.job_portal.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "job_company")
@Entity
@Data
public class JobCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "logo")
    private String logo;

    @Column(name = "name")
    private String name;

}
