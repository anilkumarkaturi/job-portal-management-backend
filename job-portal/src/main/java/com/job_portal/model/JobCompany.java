package com.job_portal.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="job_company")
@Entity
@Data
public class JobCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String logo;
    private String name;

}
