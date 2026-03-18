package com.matchserv.skillink.api.controllers;

import com.matchserv.skillink.api.dto.LoungeDto;
import com.matchserv.skillink.api.mappers.LoungeMapper;
import com.matchserv.skillink.data.models.Lounge;
import com.matchserv.skillink.data.repositories.LoungeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/lounges")
@RequiredArgsConstructor
public class LoungeController {

    private final LoungeRepository loungeRepository;
    private final LoungeMapper loungeMapper;

    @GetMapping
    public List<LoungeDto> getAll() {
        return loungeRepository.findAll().stream()
                .map(loungeMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoungeDto> getById(@PathVariable Long id) {
        return loungeRepository.findById(id)
                .map(loungeMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LoungeDto> create(@RequestBody LoungeDto dto) {
        Lounge lounge = loungeMapper.toEntity(dto);
        Lounge saved = loungeRepository.save(lounge);
        return ResponseEntity.ok(loungeMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoungeDto> update(@PathVariable Long id, @RequestBody LoungeDto dto) {
        return loungeRepository.findById(id)
                .map(existing -> {
                    Lounge updated = loungeRepository.save(existing);
                    return ResponseEntity.ok(loungeMapper.toDto(updated));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!loungeRepository.existsById(id)) return ResponseEntity.notFound().build();
        loungeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
