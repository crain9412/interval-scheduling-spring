package com.jwcrain.hooke.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "event")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventEntity {
    @Id
    private int id;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;

    @Column
    private int startTime;

    @Column
    private int endTime;
}
