package com.jwcrain.hooke.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public List<EventResource> getEvents() {
        return eventRepository
                .findAll()
                .stream()
                .map(EventResource::fromEntity)
                .collect(Collectors.toList());
    }
}
