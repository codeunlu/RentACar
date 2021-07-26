package com.codeunlu.rentacar.model.users;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@Table(name = "individuals")
@PrimaryKeyJoinColumn(name = "user_id")
public class Individual extends User{
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "national_id")
    private String nationalId;

    @OneToMany(mappedBy = "individuals")
    private Set<Contact> contacts;
}
