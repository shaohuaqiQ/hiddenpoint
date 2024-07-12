package com.shaohua.hiddenpoint.service;

import com.shaohua.hiddenpoint.entity.EventEntity;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<EventEntity> getAllEvents();
    Optional<EventEntity> getEventById(Long id);
    EventEntity createEvent(EventEntity event);
    EventEntity updateEvent(Long id, EventEntity event);
    void deleteEvent(Long id);
}
