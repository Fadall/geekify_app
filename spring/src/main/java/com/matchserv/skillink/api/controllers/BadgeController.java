package com.matchserv.skillink.api.controllers;

import com.matchserv.skillink.api.dto.BadgeDto;
import com.matchserv.skillink.data.models.Badge;
import com.matchserv.skillink.data.repositories.BadgeRepository;
import com.matchserv.skillink.api.mappers.BadgeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/badges")
@RequiredArgsConstructor
public class BadgeController {

    private final BadgeRepository badgeRepository;

    @GetMapping
    public List<BadgeDto> getAllBadges() {
        return badgeRepository.findAll()
                .stream()
                .map(BadgeMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BadgeDto> getBadgeById(@PathVariable Long id) {
        return badgeRepository.findById(id)
                .map(BadgeMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BadgeDto createBadge(@RequestBody BadgeDto badgeDto) {
        Badge badge = BadgeMapper.toEntity(badgeDto);
        return BadgeMapper.toDto(badgeRepository.save(badge));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BadgeDto> updateBadge(@PathVariable Long id, @RequestBody BadgeDto badgeDto) {
        return badgeRepository.findById(id)
                .map(existing -> {
                    existing.setName(badgeDto.getName());
                    existing.setDescription(badgeDto.getDescription());
                    existing.setImageUrl(badgeDto.getImageUrl());
                    existing.setDurationDays(badgeDto.getDurationDays());
                    return ResponseEntity.ok(BadgeMapper.toDto(badgeRepository.save(existing)));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBadge(@PathVariable Long id) {
        return badgeRepository.findById(id)
                .map(existing -> {
                    badgeRepository.delete(existing);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
