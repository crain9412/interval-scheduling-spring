package com.jwcrain.hooke.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.GET)
    public List<EventResource> getEvents() {
        return eventService.getEvents();
    }
//
//    @RequestMapping(
//            value = "/{id}",
//            method = RequestMethod.GET)
//    public List<EventResource> getEvent() {
//
//    }
}