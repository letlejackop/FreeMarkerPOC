package com.example.FreeMarkerPOC.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class parameter {

    @Id
    @SequenceGenerator(name = "param_seq", sequenceName = "param_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "param_seq")
    private long id;
    private String name;
    private String value;
}
