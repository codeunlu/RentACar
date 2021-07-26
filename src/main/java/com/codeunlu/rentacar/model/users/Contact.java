package com.codeunlu.rentacar.model.users;

import com.codeunlu.rentacar.model.enums.ContactType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false)
    private Individual individuals;

    @Column(name = "contact_type_id")
    @Enumerated
    private ContactType contactTypeId;

    @Column(name = "content")
    private String content;
}
