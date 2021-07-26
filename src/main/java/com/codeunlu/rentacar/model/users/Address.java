package com.codeunlu.rentacar.model.users;

import com.codeunlu.rentacar.model.enums.AddressType;
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
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false)
    private User users;

    @Column(name = "address_type_id")
    @Enumerated
    private AddressType addressTypeId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;
}
