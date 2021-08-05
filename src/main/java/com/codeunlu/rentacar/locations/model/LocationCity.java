package com.codeunlu.rentacar.locations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "location")
@Table(name = "location_citys")
public class LocationCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToOne(mappedBy = "locationCity")
    private Location location;

    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();
}
