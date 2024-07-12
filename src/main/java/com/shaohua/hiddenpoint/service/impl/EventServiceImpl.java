package com.shaohua.hiddenpoint.service.impl;

import com.shaohua.hiddenpoint.repository.EventRepository;
import com.shaohua.hiddenpoint.service.EventService;
import com.shaohua.hiddenpoint.entity.EventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<EventEntity> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<EventEntity> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public EventEntity createEvent(EventEntity event) {
        return eventRepository.save(event);
    }

    @Override
    public EventEntity updateEvent(Long id, EventEntity event) {
        Optional<EventEntity> existingEvent = eventRepository.findById(id);
        if (existingEvent.isPresent()) {
            EventEntity updatedEvent = existingEvent.get();
            updatedEvent.setEventId(event.getEventId());
            updatedEvent.setEventName(event.getEventName());
            updatedEvent.setEventSource(event.getEventSource());
            updatedEvent.setEventType(event.getEventType());
            updatedEvent.setEventStatus(event.getEventStatus());
            updatedEvent.setEventTriggerWhen(event.getEventTriggerWhen());
            updatedEvent.setCreator(event.getCreator());
            updatedEvent.setOnlineDate(event.getOnlineDate());
            updatedEvent.setOfflineDate(event.getOfflineDate());
            updatedEvent.setGmtModify(event.getGmtModify());
            return eventRepository.save(updatedEvent);
        } else {
            return null; // Or throw an exception
        }
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
