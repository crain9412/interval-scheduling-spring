package com.jwcrain.intervalschedulingspring.event;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Validated
public class EventResource {
    private int id;

    @NotNull
    @Min(value = 5)
    @Max(value = 16000)
    private String description;

    @NotNull
    private int startTime;

    @NotNull
    private int endTime;

    public static EventResource fromEntity(EventEntity eventEntity) {
        EventResource eventResource = new EventResource();

        eventResource.setId(eventEntity.getId());
        eventResource.setDescription(eventEntity.getDescription());
        eventResource.setStartTime(eventEntity.getStartTime());
        eventResource.setEndTime(eventEntity.getEndTime());

        return eventResource;
    }

    public EventEntity toEntity() {
        EventEntity eventEntity = new EventEntity();

        eventEntity.setId(id);
        eventEntity.setDescription(description);
        eventEntity.setStartTime(startTime);
        eventEntity.setEndTime(endTime);

        return eventEntity;
    }
}