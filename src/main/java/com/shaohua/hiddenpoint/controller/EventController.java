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

    @RequestMapping("/getallevents")
    public String getAllEvents(Model model) {
        logger.info("Entering getAllEvents method");
        List<EventEntity> eventEntities = eventService.getAllEvents();
        logger.info("Number of events retrieved: " + eventEntities.size());
        for (EventEntity eventEntity : eventEntities) {
            logger.info("Event: " + eventEntity.getEventName());
        }
        model.addAttribute("eventEntities", eventEntities);
        return "event/getallevents";
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

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("event", new EventEntity());
        return "event/createevent";
    }

    @PostMapping("/create")
    public String createEvent(@ModelAttribute EventEntity event) {
        eventService.createEvent(event);
        return "redirect:/events/getallevents";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Optional<EventEntity> event = eventService.getEventById(id);
        if (event.isPresent()) {
            model.addAttribute("event", event.get());
            return "event/updateevent";
        } else {
            return "redirect:/events/getallevents";
        }
    }

    @PostMapping("/update/{id}")
    public String updateEvent(@PathVariable Long id, @ModelAttribute EventEntity event) {
        eventService.updateEvent(id, event);
        return "redirect:/events/getallevents";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Optional<EventEntity> event = eventService.getEventById(id);
        if (event.isPresent()) {
            model.addAttribute("event", event.get());
            return "event/deleteevent";
        } else {
            return "redirect:/events/getallevents";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "redirect:/events/getallevents";
    }
}
