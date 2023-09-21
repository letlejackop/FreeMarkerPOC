package com.example.FreeMarkerPOC.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TemplateEntity {
    @Id
    @SequenceGenerator(name = "temp_seq", sequenceName = "temp_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "temp_seq")
    private long id;
    private String name;
    private String content;
    private Calendar lastModified = Calendar.getInstance();

    public void updateLastModified() {
        setLastModified(Calendar.getInstance());
    }

}
