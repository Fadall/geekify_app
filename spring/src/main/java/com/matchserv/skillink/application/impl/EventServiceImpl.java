package com.matchserv.skillink.application.impl;

import com.matchserv.skillink.application.EventService;
import com.matchserv.skillink.data.models.Event;
import com.matchserv.skillink.data.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepo;

    @Override
    public Event save(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public void delete(Event event) {
        eventRepo.delete(event);
    }

    @Override
    public Event findById(Long id) {
        return eventRepo.findById(id).orElse(null);
    }

    @Override
    public List<Event> findAll() {
        return eventRepo.findAll();
    }
}
