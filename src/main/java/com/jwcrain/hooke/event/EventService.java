package com.jwcrain.hooke.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    private static Logger logger = LoggerFactory.getLogger(EventService.class);

    public EventResource createEvent(EventResource eventResource) {
        EventEntity eventEntity = eventResource.toEntity();

        eventEntity.setId(null);

        eventEntity = eventRepository.save(eventEntity);

        return EventResource.fromEntity(eventEntity);
    }

    public List<EventResource> getEvents(Pageable pageable) {
        return eventRepository
                .findAll(pageable)
                .stream()
                .map(EventResource::fromEntity)
                .collect(Collectors.toList());
    }

    public EventResource getEvent(int id) {
        Optional<EventEntity> eventEntityOptional = eventRepository.findById(id);

        if (!eventEntityOptional.isPresent()) {
            logger.debug("Event {} not found to retrieve", id);
            return null;
        }

        return EventResource.fromEntity(eventEntityOptional.get());
    }

    /* Greedy algo to return event resources that don't conflict based on picking the one that finishes soonest */
    public List<EventResource> getSchedule() {
        List<EventEntity> eventEntities = eventRepository.findAllOrderByEndTime();

        List<EventResource> schedule = new ArrayList<>();

        EventResource currentResource = EventResource.fromEntity(eventEntities.get(0));

        schedule.add(currentResource);

        for (int i = 1; i < eventEntities.size(); i++) {
            EventEntity potentialResource = eventEntities.get(i);

            if (potentialResource.getStartTime() > currentResource.getEndTime()) {
                currentResource = EventResource.fromEntity(potentialResource);
                schedule.add(currentResource);
            }
        }

        return schedule;
    }

    public EventResource updateEvent(EventResource eventResource) {
        int id = eventResource.getId();
        Optional<EventEntity> eventEntityOptional = eventRepository.findById(id);
        EventEntity eventEntity;

        if (!eventEntityOptional.isPresent()) {
            logger.debug("Event {} not found to update", id);
            return null;
        }

        eventEntity = eventResource.toEntity();

        eventEntity.setId(eventEntityOptional.get().getId());

        return EventResource.fromEntity(eventRepository.save(eventEntity));
    }

    public EventResource deleteEvent(int id) {
        Optional<EventEntity> eventEntityOptional = eventRepository.findById(id);
        EventEntity eventEntity;

        if (!eventEntityOptional.isPresent()) {
            logger.debug("Event {} not found to delete", id);
            return null;
        }

        eventEntity = eventEntityOptional.get();

        eventRepository.delete(eventEntity);

        return EventResource.fromEntity(eventEntity);
    }
}
