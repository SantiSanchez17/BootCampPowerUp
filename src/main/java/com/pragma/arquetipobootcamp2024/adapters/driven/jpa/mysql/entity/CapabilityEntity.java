package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "capacidad")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CapabilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String descrip;

}
