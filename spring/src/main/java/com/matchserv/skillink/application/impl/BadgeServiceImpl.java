package com.matchserv.skillink.application.impl;

import com.matchserv.skillink.application.BadgeService;
import com.matchserv.skillink.data.models.Badge;
import com.matchserv.skillink.data.repositories.BadgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BadgeServiceImpl implements BadgeService {

    private final BadgeRepository badgeRepo;

    @Override
    public Badge save(Badge badge) {
        return badgeRepo.save(badge);
    }

    @Override
    public void delete(Badge badge) {
        badgeRepo.delete(badge);
    }

    @Override
    public Badge findById(Long id) {
        return badgeRepo.findById(id).orElse(null);
    }

    @Override
    public List<Badge> findAll() {
        return badgeRepo.findAll();
    }
}
