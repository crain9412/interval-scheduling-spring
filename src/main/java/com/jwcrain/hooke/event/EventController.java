package com.jwcrain.hooke.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.POST)
    public EventResource createEvent(
            @RequestBody EventResource eventResource
    ) {
        return eventService.createEvent(eventResource);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<EventResource> getEvents(Pageable pageable) {
        return eventService.getEvents(pageable);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET
    )
    public EventResource getEvent(@PathVariable(name="id") Integer id) {
        return eventService.getEvent(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public EventResource updateEvent(
            @RequestBody EventResource eventResource
    ) {
        return eventService.updateEvent(eventResource);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public EventResource deleteEvent(@PathVariable(name = "id") Integer id) {
        return eventService.deleteEvent(id);
    }
}