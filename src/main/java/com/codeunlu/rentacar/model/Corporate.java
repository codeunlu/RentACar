package com.codeunlu.rentacar.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "corporates")
@PrimaryKeyJoinColumn(name = "user_id")
public class Corporate extends User{
    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_url")
    private String companyURI;

    @Column(name = "company_contact")
    private String companyContact;
}
