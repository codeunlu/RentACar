package com.codeunlu.rentacar.accounts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "account")
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "content")
    private String content;

    @Enumerated
    @Column(name = "contact_type_id")
    private ContactType contactType;

    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();
}
