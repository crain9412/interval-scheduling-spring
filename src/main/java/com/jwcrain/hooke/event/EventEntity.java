package com.jwcrain.hooke.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "event")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;

    @Column
    private int startTime;

    @Column
    private int endTime;
}
