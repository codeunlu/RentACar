package com.codeunlu.rentacar.model.users;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
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
