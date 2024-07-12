package com.shaohua.hiddenpoint.controller;

import com.shaohua.hiddenpoint.entity.EventEntity;
import com.shaohua.hiddenpoint.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/events")
public class EventController {

    private static final Logger logger = Logger.getLogger(EventController.class.getName());

    @Autowired
    private EventService eventService;

    @RequestMapping
    public String getAllEvents(Model model) {
        logger.info("Entering getAllEvents method");
        List<EventEntity> eventEntities = eventService.getAllEvents();
        logger.info("Number of events retrieved: " + eventEntities.size());
        for (EventEntity eventEntity : eventEntities) {
            logger.info("Event: " + eventEntity.getEventName());
        }
        model.addAttribute("eventEntities", eventEntities);
        return "events";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<EventEntity> getEventById(@PathVariable Long id) {
        Optional<EventEntity> event = eventService.getEventById(id);
        if (event.isPresent()) {
            return ResponseEntity.ok(event.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
