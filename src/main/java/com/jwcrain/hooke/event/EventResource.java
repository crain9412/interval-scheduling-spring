package com.jwcrain.hooke.event;

import lombok.Data;

@Data
public class EventResource {
    private int id;
    private String description;
    private int startTime;
    private int endTime;

    public static EventResource fromEntity(EventEntity eventEntity) {
        EventResource eventResource = new EventResource();

        eventResource.setId(eventEntity.getId());
        eventResource.setDescription(eventEntity.getDescription());
        eventResource.setStartTime(eventEntity.getStartTime());
        eventResource.setEndTime(eventEntity.getEndTime());

        return eventResource;
    }
}